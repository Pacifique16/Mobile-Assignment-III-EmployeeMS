# Quick Start Guide - Employee Management App

## Project Setup in Android Studio

### Step 1: Open Project
1. Open Android Studio
2. Click "Open an Existing Project"
3. Navigate to: `C:\Users\Pacifique Harerimana\OneDrive\Desktop\AUCA\Semester 8\Mobile Programming\Assignment III`
4. Click "OK"

### Step 2: Sync Gradle
1. Wait for Android Studio to index files
2. Click "Sync Now" if prompted
3. Wait for Gradle sync to complete

### Step 3: Configure Emulator (if needed)
1. Click "Device Manager" in Android Studio
2. Create new virtual device or use existing
3. Recommended: Pixel 5 with API 33 (Android 13)

### Step 4: Run the App
1. Click the green "Run" button (or Shift+F10)
2. Select your emulator or connected device
3. Wait for app to build and install

## Project File Structure Overview

```
Assignment III/
│
├── app/
│   ├── src/main/
│   │   ├── java/com/auca/employeemanagement/
│   │   │   ├── Employee.java                          # Data model
│   │   │   ├── EmployeeManager.java                   # Singleton data manager
│   │   │   ├── EmployeeListActivity.java              # Main screen
│   │   │   ├── EmployeeDetailActivity.java            # Detail view
│   │   │   ├── EmployeeRegistrationActivity.java      # Add employee
│   │   │   ├── DepartmentActivity.java                # Department list
│   │   │   ├── EmployeeInDepartmentDetailActivity.java # Filtered view
│   │   │   └── MusicPlayerService.java                # Background service
│   │   │
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_employee_list.xml
│   │   │   │   ├── activity_employee_detail.xml
│   │   │   │   ├── activity_employee_registration.xml
│   │   │   │   ├── activity_department.xml
│   │   │   │   └── activity_employee_in_department.xml
│   │   │   │
│   │   │   └── values/
│   │   │       ├── strings.xml
│   │   │       ├── colors.xml
│   │   │       └── themes.xml
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   ├── build.gradle
│   └── proguard-rules.pro
│
├── build.gradle
├── settings.gradle
├── gradle.properties
├── .gitignore
├── README.md
├── GIT_COMMIT_GUIDE.md
└── TESTING_GUIDE.md
```

## Key Features Quick Reference

### 1. Main Screen (EmployeeListActivity)
- **What it does:** Shows all employees in a list
- **Actions:**
  - Click employee → View details
  - Click "Register" → Add new employee
  - Click "Departments" → Browse by department
  - Click "Stop Music" → Stop background service

### 2. Employee Detail Screen
- **What it does:** Shows complete employee info
- **Actions:**
  - Click phone number → Opens dialer
  - Click email → Opens email app

### 3. Registration Screen
- **What it does:** Add new employees
- **Fields:** ID, Name, Gender, Email, Phone, Department

### 4. Department Screens
- **What it does:** Browse employees by department
- **Flow:** Departments → Select Department → View Employees → Employee Details

### 5. Background Service
- **What it does:** Runs music service in background
- **Behavior:** Starts automatically, continues during navigation

## Code Highlights

### Passing Data Between Activities
```java
// Sending data
Intent intent = new Intent(this, EmployeeDetailActivity.class);
intent.putExtra("employee", employee);
startActivity(intent);

// Receiving data
Employee emp = (Employee) getIntent().getSerializableExtra("employee");
```

### Implicit Intents
```java
// Phone dialer
Intent dialIntent = new Intent(Intent.ACTION_DIAL);
dialIntent.setData(Uri.parse("tel:" + phoneNumber));
startActivity(dialIntent);

// Email
Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
emailIntent.setData(Uri.parse("mailto:" + email));
startActivity(emailIntent);
```

### ListView with Click Listener
```java
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Employee employee = adapter.getItem(position);
        // Navigate to detail screen
    }
});
```

## Git Setup and First Commits

### Initialize Repository
```bash
cd "C:\Users\Pacifique Harerimana\OneDrive\Desktop\AUCA\Semester 8\Mobile Programming\Assignment III"
git init
git config user.name "Your Name"
git config user.email "your.email@auca.ac.rw"
```

### First Commits
```bash
git add README.md
git commit -m "Initial commit: Add project documentation"

git add .gitignore
git commit -m "Add gitignore for Android project"

git add build.gradle settings.gradle gradle.properties
git commit -m "Add Gradle configuration files"
```

### Connect to GitLab
```bash
git remote add origin https://gitlab.com/yourusername/employee-management.git
git branch -M main
git push -u origin main
```

## Troubleshooting

### Problem: Gradle sync fails
**Solution:** 
- Check internet connection
- File → Invalidate Caches → Restart
- Update Android Studio to latest version

### Problem: App won't run
**Solution:**
- Check emulator is running
- Clean project: Build → Clean Project
- Rebuild: Build → Rebuild Project

### Problem: Import errors in Java files
**Solution:**
- Let Android Studio auto-import
- Or manually add: Alt+Enter on red underlined code

### Problem: Layout not showing
**Solution:**
- Check XML syntax
- Verify resource IDs match Java code
- Rebuild project

## Testing Checklist

Before submission, verify:
- [ ] App runs without crashes
- [ ] All 5 activities are accessible
- [ ] ListView displays employees
- [ ] Click on employee shows details
- [ ] Phone click opens dialer
- [ ] Email click opens email app
- [ ] Registration adds new employee
- [ ] Department filtering works
- [ ] Background service starts/stops
- [ ] At least 20 commits on GitLab

## Assignment Submission

### Required Items:
1. ✅ GitLab repository link
2. ✅ Screenshots (4 minimum):
   - Employee list
   - Employee detail
   - Dialer opened
   - Email app opened
3. ✅ README.md with documentation
4. ✅ 20+ commits visible on GitLab

### Grading Breakdown:
- ListView implementation: 4 points
- GitLab commits: 3 points
- Intents usage: 3 points
- Clickable phone/email: 3 points
- Background service: 3 points
- Code quality & documentation: 4 points
- **Total: 20 points**

## Next Steps

1. ✅ Open project in Android Studio
2. ✅ Run and test the app
3. ✅ Initialize Git repository
4. ✅ Make 20+ commits (see GIT_COMMIT_GUIDE.md)
5. ✅ Take required screenshots
6. ✅ Push to GitLab
7. ✅ Submit assignment

## Support Resources

- **Android Documentation:** https://developer.android.com
- **Intents Guide:** https://developer.android.com/guide/components/intents-filters
- **ListView Tutorial:** https://developer.android.com/guide/topics/ui/layout/listview
- **Services Guide:** https://developer.android.com/guide/components/services

## Contact

For questions about this project:
- Check TESTING_GUIDE.md for common issues
- Review README.md for detailed documentation
- Consult your instructor during office hours

---

**Good luck with your assignment! 🚀**

Remember: Make small, frequent commits and test each feature as you build it!
