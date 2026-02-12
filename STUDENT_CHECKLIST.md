# Student Progress Checklist

## 📋 Pre-Submission Checklist

Use this checklist to ensure you've completed all requirements before submitting your assignment.

---

## Phase 1: Project Setup ✓

- [x] Project structure created
- [x] All Java files created
- [x] All layout XML files created
- [x] AndroidManifest.xml configured
- [x] Gradle files configured
- [x] Documentation files created

---

## Phase 2: Testing & Verification

### A. Code Compilation
- [ ] Project opens in Android Studio without errors
- [ ] Gradle sync completes successfully
- [ ] No compilation errors in any Java file
- [ ] No errors in XML layout files
- [ ] App builds successfully

### B. ListView Implementation (/4 points)
- [ ] EmployeeListActivity displays correctly
- [ ] ListView shows all employees
- [ ] Each item shows Employee ID and Name
- [ ] ListView is scrollable
- [ ] Clicking an item navigates to detail screen
- [ ] List refreshes when returning from registration

### C. Intents for Navigation (/3 points)
- [ ] Click employee → Opens EmployeeDetailActivity
- [ ] "Register" button → Opens EmployeeRegistrationActivity
- [ ] "Departments" button → Opens DepartmentActivity
- [ ] Click department → Opens EmployeeInDepartmentDetailActivity
- [ ] Click employee in department → Opens EmployeeDetailActivity
- [ ] All data passes correctly between activities
- [ ] No crashes during navigation

### D. Clickable Phone and Email (/3 points)
- [ ] Phone number displays in blue color
- [ ] Phone number is clickable
- [ ] Clicking phone opens dialer
- [ ] Correct phone number appears in dialer
- [ ] Email address displays in blue color
- [ ] Email address is clickable
- [ ] Clicking email opens email app
- [ ] Correct email address appears in email app

### E. Background Service (/3 points)
- [ ] Service starts automatically on app launch
- [ ] Toast message shows "Background Music Service Started"
- [ ] Service continues running when navigating to EmployeeDetailActivity
- [ ] Service continues running when navigating to RegistrationActivity
- [ ] Service continues running when navigating to DepartmentActivity
- [ ] "Stop Background Music" button works
- [ ] Toast message shows "Background Music Service Stopped"
- [ ] Service actually stops when button is clicked

### F. Code Quality & Documentation (/4 points)
- [ ] Code is well-organized and readable
- [ ] Proper naming conventions used (camelCase for variables, PascalCase for classes)
- [ ] No unused imports or variables
- [ ] Comments added where necessary
- [ ] No hardcoded strings (or minimal)
- [ ] Proper error handling (try-catch where needed)
- [ ] Form validation works in registration
- [ ] UI is clean and professional
- [ ] README.md is complete and accurate
- [ ] All documentation files are present

---

## Phase 3: Git & GitLab (/3 points)

### A. Git Repository Setup
- [ ] Git initialized in project directory
- [ ] .gitignore file configured
- [ ] Git user name configured
- [ ] Git user email configured

### B. Commits (Minimum 20 Required)
Track your commits here:

1. [ ] Commit 1: ___________________________________
2. [ ] Commit 2: ___________________________________
3. [ ] Commit 3: ___________________________________
4. [ ] Commit 4: ___________________________________
5. [ ] Commit 5: ___________________________________
6. [ ] Commit 6: ___________________________________
7. [ ] Commit 7: ___________________________________
8. [ ] Commit 8: ___________________________________
9. [ ] Commit 9: ___________________________________
10. [ ] Commit 10: ___________________________________
11. [ ] Commit 11: ___________________________________
12. [ ] Commit 12: ___________________________________
13. [ ] Commit 13: ___________________________________
14. [ ] Commit 14: ___________________________________
15. [ ] Commit 15: ___________________________________
16. [ ] Commit 16: ___________________________________
17. [ ] Commit 17: ___________________________________
18. [ ] Commit 18: ___________________________________
19. [ ] Commit 19: ___________________________________
20. [ ] Commit 20: ___________________________________
21. [ ] Commit 21 (Bonus): ___________________________________
22. [ ] Commit 22 (Bonus): ___________________________________

### C. GitLab Setup
- [ ] GitLab account created
- [ ] New repository created on GitLab
- [ ] Repository is public or accessible to instructor
- [ ] Remote origin added to local repository
- [ ] Code pushed to GitLab
- [ ] All commits visible on GitLab
- [ ] Contribution graph shows activity
- [ ] README.md displays correctly on GitLab

---

## Phase 4: Screenshots

### Required Screenshots (4 minimum)
- [ ] Screenshot 1: Employee list screen
  - File name: `screenshot_employee_list.png`
  - Shows: ListView with all employees
  
- [ ] Screenshot 2: Employee detail screen
  - File name: `screenshot_employee_detail.png`
  - Shows: All employee details with clickable phone/email
  
- [ ] Screenshot 3: Dialer opened
  - File name: `screenshot_dialer.png`
  - Shows: Phone dialer with employee number
  
- [ ] Screenshot 4: Email app opened
  - File name: `screenshot_email.png`
  - Shows: Email app with employee email

### Bonus Screenshots
- [ ] Screenshot 5: Registration form
- [ ] Screenshot 6: Department list
- [ ] Screenshot 7: Department employees
- [ ] Screenshot 8: Service toast notification

---

## Phase 5: Final Submission

### A. Files to Submit
- [ ] GitLab repository link
- [ ] Screenshot 1 (Employee list)
- [ ] Screenshot 2 (Employee detail)
- [ ] Screenshot 3 (Dialer)
- [ ] Screenshot 4 (Email app)
- [ ] Any additional screenshots

### B. Pre-Submission Verification
- [ ] GitLab repository link is correct and accessible
- [ ] Repository contains all project files
- [ ] README.md is visible and complete
- [ ] At least 20 commits are visible
- [ ] Commits have clear, descriptive messages
- [ ] Screenshots are clear and show required features
- [ ] All screenshots are properly named

### C. Final Testing
- [ ] Clone repository to a new location
- [ ] Open cloned project in Android Studio
- [ ] Project builds successfully
- [ ] App runs without errors
- [ ] All features work as expected

---

## Grading Summary

| Criteria | Points | Self-Assessment |
|----------|--------|-----------------|
| ListView implementation | /4 | ___/4 |
| GitLab commits (20+) | /3 | ___/3 |
| Intents for navigation | /3 | ___/3 |
| Clickable Phone/Email | /3 | ___/3 |
| Background Service | /3 | ___/3 |
| Code quality & docs | /4 | ___/4 |
| **TOTAL** | **/20** | **___/20** |

---

## Extra Credit Opportunities

If you want to go above and beyond:

- [ ] Add SQLite database for persistent storage (+2 points)
- [ ] Implement search functionality (+1 point)
- [ ] Add employee photos (+1 point)
- [ ] Create custom ListView adapter with better UI (+1 point)
- [ ] Add edit/delete employee functionality (+2 points)
- [ ] Implement data export (CSV/PDF) (+1 point)
- [ ] Add splash screen (+1 point)
- [ ] Implement SharedPreferences for settings (+1 point)
- [ ] Add animations between activities (+1 point)
- [ ] Create app icon and branding (+1 point)

---

## Common Issues Checklist

If something isn't working, check these:

### App Won't Build
- [ ] Gradle sync completed?
- [ ] Internet connection active?
- [ ] Android Studio updated?
- [ ] SDK installed?

### ListView Not Showing
- [ ] Adapter set correctly?
- [ ] EmployeeManager returning data?
- [ ] Layout XML correct?

### Intents Not Working
- [ ] Activity declared in AndroidManifest?
- [ ] Intent created correctly?
- [ ] Data being passed correctly?

### Phone/Email Not Clickable
- [ ] TextView has clickable="true"?
- [ ] OnClickListener set?
- [ ] Permissions in AndroidManifest?

### Service Not Starting
- [ ] Service declared in AndroidManifest?
- [ ] startService() called?
- [ ] Service class extends Service?

### Git Issues
- [ ] Git initialized?
- [ ] Remote added?
- [ ] Commits made?
- [ ] Pushed to GitLab?

---

## Submission Deadline Reminder

**Due Date:** ___________________

**Time:** ___________________

**Submission Method:** ___________________

---

## Notes & Reminders

Use this space for any notes or reminders:

_______________________________________________________________

_______________________________________________________________

_______________________________________________________________

_______________________________________________________________

_______________________________________________________________

---

## Instructor Contact

**Name:** ___________________

**Email:** ___________________

**Office Hours:** ___________________

---

**Good luck with your assignment! 🎓**

Remember: Test early, test often, and commit frequently!

---

## Quick Reference Commands

### Git Commands
```bash
# Initialize repository
git init

# Check status
git status

# Add files
git add .

# Commit
git commit -m "Your message"

# Add remote
git remote add origin <url>

# Push to GitLab
git push -u origin main

# View commit history
git log --oneline
```

### Android Studio Shortcuts
- **Run App:** Shift + F10
- **Build Project:** Ctrl + F9
- **Clean Project:** Build → Clean Project
- **Sync Gradle:** File → Sync Project with Gradle Files

---

**Last Updated:** [Date]

**Completed By:** ___________________

**Signature:** ___________________
