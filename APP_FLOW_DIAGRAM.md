# Employee Management App - Visual Flow Diagram

## App Architecture Overview

```
┌─────────────────────────────────────────────────────────────────┐
│                     EMPLOYEE MANAGEMENT SYSTEM                   │
└─────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                         DATA LAYER                               │
├─────────────────────────────────────────────────────────────────┤
│  Employee.java (Model)                                           │
│  - employeeId: String                                            │
│  - names: String                                                 │
│  - gender: String                                                │
│  - email: String                                                 │
│  - phone: String                                                 │
│  - department: String                                            │
│  - implements Serializable                                       │
├─────────────────────────────────────────────────────────────────┤
│  EmployeeManager.java (Singleton)                                │
│  - List<Employee> employees                                      │
│  + getInstance()                                                 │
│  + addEmployee(Employee)                                         │
│  + getAllEmployees()                                             │
│  + getEmployeesByDepartment(String)                              │
└─────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                      PRESENTATION LAYER                          │
└─────────────────────────────────────────────────────────────────┘
```

## Screen Flow Diagram

```
                    ┌──────────────────────────┐
                    │   App Launch (Splash)    │
                    └────────────┬─────────────┘
                                 │
                                 ▼
                    ┌──────────────────────────┐
                    │  EmployeeListActivity    │◄──────┐
                    │  (MAIN/LAUNCHER)         │       │
                    │                          │       │
                    │  • ListView of Employees │       │
                    │  • Register Button       │       │
                    │  • Departments Button    │       │
                    │  • Stop Music Button     │       │
                    └──┬────────┬──────────┬───┘       │
                       │        │          │           │
         ┌─────────────┘        │          └──────┐    │
         │                      │                 │    │
         ▼                      ▼                 ▼    │
┌─────────────────┐   ┌──────────────────┐   ┌──────────────────┐
│ Employee        │   │ Department       │   │ Employee         │
│ Registration    │   │ Activity         │   │ Detail           │
│ Activity        │   │                  │   │ Activity         │
│                 │   │ • List of        │   │                  │
│ • Form Fields   │   │   Departments    │   │ • All Employee   │
│ • Save Button   │   │ • Click to View  │   │   Details        │
│                 │   │   Employees      │   │ • Clickable      │
└────────┬────────┘   └────────┬─────────┘   │   Phone          │
         │                     │              │ • Clickable      │
         │ Save                │              │   Email          │
         │                     ▼              └──┬───────┬───────┘
         │            ┌──────────────────┐      │       │
         └───────────►│ Employee In      │      │       │
                      │ Department       │      │       │
                      │ Detail Activity  │      │       │
                      │                  │      │       │
                      │ • Filtered List  │      │       │
                      │ • Click Employee │      │       │
                      └────────┬─────────┘      │       │
                               │                │       │
                               └────────────────┘       │
                                                        │
                    ┌───────────────────────────────────┤
                    │                                   │
                    ▼                                   ▼
         ┌──────────────────┐              ┌──────────────────┐
         │  Phone Dialer    │              │  Email App       │
         │  (System App)    │              │  (System App)    │
         │                  │              │                  │
         │  ACTION_DIAL     │              │  ACTION_SENDTO   │
         │  Implicit Intent │              │  Implicit Intent │
         └──────────────────┘              └──────────────────┘
```

## Background Service Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    BACKGROUND SERVICE LIFECYCLE                  │
└─────────────────────────────────────────────────────────────────┘

App Launch
    │
    ├─► startService(MusicPlayerService)
    │
    ▼
┌─────────────────────────┐
│  MusicPlayerService     │
│  onCreate()             │
│  - Initialize MediaPlayer│
└────────┬────────────────┘
         │
         ▼
┌─────────────────────────┐
│  onStartCommand()       │
│  - Start playing music  │
│  - Show Toast           │
│  - Return START_STICKY  │
└────────┬────────────────┘
         │
         │  ┌─────────────────────────────────┐
         │  │  Service runs in background     │
         │  │  while user navigates:          │
         ├─►│  • EmployeeListActivity         │
         │  │  • EmployeeDetailActivity       │
         │  │  • RegistrationActivity         │
         │  │  • DepartmentActivity           │
         │  │  • EmployeeInDepartmentActivity │
         │  └─────────────────────────────────┘
         │
         │  User clicks "Stop Music"
         │
         ▼
┌─────────────────────────┐
│  stopService()          │
│  onDestroy()            │
│  - Stop MediaPlayer     │
│  - Release resources    │
│  - Show Toast           │
└─────────────────────────┘
```

## Intent Data Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                      EXPLICIT INTENTS                            │
└─────────────────────────────────────────────────────────────────┘

1. Employee List → Employee Detail
   ┌──────────────────────────────────────────────────────────┐
   │ Intent intent = new Intent(this, EmployeeDetailActivity) │
   │ intent.putExtra("employee", employeeObject)              │
   │ startActivity(intent)                                    │
   └──────────────────────────────────────────────────────────┘
   
2. Employee List → Registration
   ┌──────────────────────────────────────────────────────────┐
   │ Intent intent = new Intent(this, EmployeeRegistration)   │
   │ startActivity(intent)                                    │
   └──────────────────────────────────────────────────────────┘

3. Employee List → Departments
   ┌──────────────────────────────────────────────────────────┐
   │ Intent intent = new Intent(this, DepartmentActivity)     │
   │ startActivity(intent)                                    │
   └──────────────────────────────────────────────────────────┘

4. Departments → Employee In Department
   ┌──────────────────────────────────────────────────────────┐
   │ Intent intent = new Intent(this, EmployeeInDepartment)   │
   │ intent.putExtra("department", departmentName)            │
   │ startActivity(intent)                                    │
   └──────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                      IMPLICIT INTENTS                            │
└─────────────────────────────────────────────────────────────────┘

1. Phone Click → Dialer
   ┌──────────────────────────────────────────────────────────┐
   │ Intent dialIntent = new Intent(Intent.ACTION_DIAL)       │
   │ dialIntent.setData(Uri.parse("tel:" + phoneNumber))      │
   │ startActivity(dialIntent)                                │
   └──────────────────────────────────────────────────────────┘
   
2. Email Click → Email App
   ┌──────────────────────────────────────────────────────────┐
   │ Intent emailIntent = new Intent(Intent.ACTION_SENDTO)    │
   │ emailIntent.setData(Uri.parse("mailto:" + email))        │
   │ emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")    │
   │ startActivity(Intent.createChooser(emailIntent, "Send")) │
   └──────────────────────────────────────────────────────────┘
```

## ListView Implementation Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    LISTVIEW DATA BINDING                         │
└─────────────────────────────────────────────────────────────────┘

EmployeeManager.getInstance()
        │
        ▼
getAllEmployees() returns List<Employee>
        │
        ▼
ArrayAdapter<Employee> adapter = new ArrayAdapter<>(
    context,
    android.R.layout.simple_list_item_1,
    employeeList
)
        │
        ▼
listView.setAdapter(adapter)
        │
        ▼
┌─────────────────────────┐
│  ListView Display       │
│  ┌───────────────────┐  │
│  │ EMP001 - John Doe │  │
│  ├───────────────────┤  │
│  │ EMP002 - Jane Sm. │  │
│  ├───────────────────┤  │
│  │ EMP003 - Bob John │  │
│  └───────────────────┘  │
└─────────────────────────┘
        │
        │ User clicks item
        ▼
listView.setOnItemClickListener()
        │
        ▼
Employee employee = adapter.getItem(position)
        │
        ▼
Navigate to EmployeeDetailActivity with employee data
```

## Activity Lifecycle with Service

```
┌─────────────────────────────────────────────────────────────────┐
│              ACTIVITY LIFECYCLE + SERVICE                        │
└─────────────────────────────────────────────────────────────────┘

EmployeeListActivity
    onCreate() ──► startService(MusicPlayerService)
        │
        ▼
    onResume() ──► loadEmployees()
        │
        │  User navigates to EmployeeDetailActivity
        ▼
    onPause()
        │
        │  Service continues running ✓
        │
        │  User presses back
        ▼
    onResume() ──► loadEmployees() (refresh list)
        │
        │  Service still running ✓
        │
        │  User clicks "Stop Music"
        ▼
    stopService(MusicPlayerService)
        │
        ▼
    Service.onDestroy()
```

## Data Persistence Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    DATA PERSISTENCE (IN-MEMORY)                  │
└─────────────────────────────────────────────────────────────────┘

App Launch
    │
    ▼
EmployeeManager.getInstance()
    │
    ├─► Initialize with sample data
    │   • EMP001 - John Doe (IT)
    │   • EMP002 - Jane Smith (HR)
    │   • EMP003 - Bob Johnson (Finance)
    │
    ▼
User adds new employee via RegistrationActivity
    │
    ▼
EmployeeManager.addEmployee(newEmployee)
    │
    ▼
List<Employee> updated in memory
    │
    ▼
Return to EmployeeListActivity
    │
    ▼
onResume() calls loadEmployees()
    │
    ▼
ListView refreshed with new data
    │
    │  Data persists while app is running
    │  Data lost when app is closed (no database)
    ▼
```

## UI Component Hierarchy

```
EmployeeListActivity
├── LinearLayout (vertical)
    ├── TextView (Title: "Employee Management System")
    ├── LinearLayout (horizontal)
    │   ├── Button (Register)
    │   └── Button (Departments)
    ├── Button (Stop Background Music)
    ├── TextView (Label: "All Employees")
    └── ListView (Employee List)

EmployeeDetailActivity
├── LinearLayout (vertical)
    ├── TextView (Title: "Employee Details")
    ├── TextView (Employee ID)
    ├── TextView (Name)
    ├── TextView (Gender)
    ├── TextView (Department)
    ├── TextView (Label: "Phone (Click to Call)")
    ├── TextView (Phone - Clickable)
    ├── TextView (Label: "Email (Click to Send)")
    └── TextView (Email - Clickable)

EmployeeRegistrationActivity
├── ScrollView
    └── LinearLayout (vertical)
        ├── TextView (Title: "Register New Employee")
        ├── TextView (Label: "Employee ID")
        ├── EditText (Employee ID input)
        ├── TextView (Label: "Full Name")
        ├── EditText (Name input)
        ├── TextView (Label: "Gender")
        ├── RadioGroup
        │   ├── RadioButton (Male)
        │   └── RadioButton (Female)
        ├── TextView (Label: "Email")
        ├── EditText (Email input)
        ├── TextView (Label: "Phone")
        ├── EditText (Phone input)
        ├── TextView (Label: "Department")
        ├── EditText (Department input)
        └── Button (Save Employee)
```

## Summary Statistics

```
┌─────────────────────────────────────────────────────────────────┐
│                      PROJECT STATISTICS                          │
├─────────────────────────────────────────────────────────────────┤
│  Total Activities:              5                                │
│  Total Java Classes:            8                                │
│  Total Layout Files:            5                                │
│  Total Intents (Explicit):      5                                │
│  Total Intents (Implicit):      2                                │
│  Total Services:                1                                │
│  Total Lines of Code:           ~1000+                           │
│  Total Documentation Pages:     5                                │
└─────────────────────────────────────────────────────────────────┘
```

---

**This diagram provides a complete visual overview of the app architecture and flow!**
