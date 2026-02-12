# Testing Guide and Screenshots Instructions

## Required Screenshots for Submission

### 1. Employee List Screen
**What to capture:**
- Main screen showing ListView with all employees
- Should display Employee ID and Name for each entry
- Navigation buttons (Register, Departments, Stop Music) visible

**How to test:**
1. Launch the app
2. Verify all 3 sample employees are displayed
3. Take screenshot

### 2. Employee Detail Screen
**What to capture:**
- Complete employee information displayed
- Phone number in blue (clickable)
- Email address in blue (clickable)
- All fields properly labeled

**How to test:**
1. From employee list, click on any employee
2. Verify all details are shown
3. Take screenshot

### 3. Dialer App Opened
**What to capture:**
- Phone dialer with employee's phone number pre-filled
- Shows the implicit intent working

**How to test:**
1. Open employee detail screen
2. Click on the phone number (blue text)
3. Dialer should open with number pre-filled
4. Take screenshot of dialer

### 4. Email App Opened
**What to capture:**
- Email application with employee's email pre-filled
- Shows the implicit intent working

**How to test:**
1. Open employee detail screen
2. Click on the email address (blue text)
3. Email app should open with address pre-filled
4. Take screenshot of email app

### 5. Employee Registration Screen (Bonus)
**What to capture:**
- Registration form with all input fields
- Shows the complete form layout

**How to test:**
1. From main screen, click "Register" button
2. Take screenshot of the form

### 6. Department List Screen (Bonus)
**What to capture:**
- List of all departments

**How to test:**
1. From main screen, click "Departments" button
2. Take screenshot

### 7. Department Employees Screen (Bonus)
**What to capture:**
- Employees filtered by department

**How to test:**
1. From department list, click any department
2. Take screenshot showing filtered employees

## Complete Testing Checklist

### ListView Implementation (/4)
- [ ] Employee list displays correctly
- [ ] ListView shows Employee ID and Name
- [ ] List is scrollable (if many employees)
- [ ] Click on item navigates to detail screen

### Intents for Navigation (/3)
- [ ] Click employee → Opens EmployeeDetailActivity
- [ ] Register button → Opens EmployeeRegistrationActivity
- [ ] Departments button → Opens DepartmentActivity
- [ ] Department click → Opens EmployeeInDepartmentDetailActivity
- [ ] Data passes correctly between activities

### Clickable Phone and Email (/3)
- [ ] Phone number is displayed in blue
- [ ] Phone number is clickable
- [ ] Clicking phone opens dialer with correct number
- [ ] Email is displayed in blue
- [ ] Email is clickable
- [ ] Clicking email opens email app with correct address

### Background Service (/3)
- [ ] Service starts when app launches
- [ ] Toast message shows "Background Music Service Started"
- [ ] Service continues running when navigating between activities
- [ ] Stop button stops the service
- [ ] Toast message shows "Background Music Service Stopped"

### Code Quality and UI (/4)
- [ ] Code is well-organized and readable
- [ ] Proper naming conventions used
- [ ] UI is clean and user-friendly
- [ ] No crashes or errors
- [ ] Proper error handling (empty fields, etc.)

### GitLab Commits (/3)
- [ ] At least 20 commits
- [ ] Commits are well-described
- [ ] Commits show progressive development
- [ ] Contribution graph is visible on GitLab

## Testing Scenarios

### Scenario 1: View Employee Details
1. Launch app
2. See list of employees
3. Click "EMP001 - John Doe"
4. Verify all details displayed correctly
5. Click phone number → Dialer opens
6. Go back, click email → Email app opens

### Scenario 2: Register New Employee
1. From main screen, click "Register"
2. Fill in all fields:
   - Employee ID: EMP004
   - Name: Alice Williams
   - Gender: Female
   - Email: alice.williams@auca.ac.rw
   - Phone: +250788456789
   - Department: Marketing
3. Click "Save Employee"
4. Should return to main screen
5. Verify new employee appears in list

### Scenario 3: Browse by Department
1. From main screen, click "Departments"
2. Click "IT" department
3. Should show only IT employees
4. Click on an employee
5. Should show employee details

### Scenario 4: Background Service
1. Launch app (service starts automatically)
2. Navigate to Registration screen
3. Navigate to Departments screen
4. Navigate to Employee Details
5. Service should still be running
6. Return to main screen
7. Click "Stop Background Music"
8. Service should stop

## Common Issues and Solutions

### Issue: App crashes on employee click
**Solution:** Ensure Employee class implements Serializable

### Issue: Phone/Email not clickable
**Solution:** Check that TextViews have clickable="true" and focusable="true"

### Issue: Dialer doesn't open
**Solution:** Verify CALL_PHONE permission in AndroidManifest.xml

### Issue: Service doesn't start
**Solution:** Check service is declared in AndroidManifest.xml

### Issue: New employee doesn't appear
**Solution:** Ensure onResume() calls loadEmployees() to refresh list

## Performance Testing

1. **Memory Usage:** Monitor app doesn't leak memory when navigating
2. **Responsiveness:** All clicks should respond immediately
3. **Data Persistence:** EmployeeManager maintains data across activities
4. **Service Lifecycle:** Service survives activity changes

## Submission Checklist

- [ ] All Java files created and working
- [ ] All XML layouts created and displaying correctly
- [ ] AndroidManifest.xml properly configured
- [ ] README.md completed with full documentation
- [ ] At least 20 commits on GitLab
- [ ] 4 required screenshots taken
- [ ] GitLab repository link ready
- [ ] Code tested on emulator/device
- [ ] No compilation errors
- [ ] All features working as expected

## Extra Credit Opportunities

1. Add SQLite database for persistent storage
2. Implement search functionality
3. Add employee photos
4. Create custom ListView adapter with better UI
5. Add edit/delete employee functionality
6. Implement data export feature
7. Add animations between activities
8. Create splash screen
9. Add input validation with regex
10. Implement SharedPreferences for settings

Good luck with your assignment! 🎓
