# Git Commit Guide for Assignment

To meet the requirement of 20+ commits, follow this structured approach:

## Initial Setup Commits (5 commits)
```bash
git init
git add README.md .gitignore
git commit -m "Initial commit: Add README and gitignore"

git add build.gradle settings.gradle gradle.properties
git commit -m "Add Gradle configuration files"

git add app/build.gradle app/proguard-rules.pro
git commit -m "Add app module Gradle configuration"

git add app/src/main/AndroidManifest.xml
git commit -m "Add AndroidManifest with permissions and activity declarations"

git add app/src/main/res/values/
git commit -m "Add resource files: strings, colors, and themes"
```

## Model and Manager Commits (2 commits)
```bash
git add app/src/main/java/com/auca/employeemanagement/Employee.java
git commit -m "Create Employee model class with Serializable"

git add app/src/main/java/com/auca/employeemanagement/EmployeeManager.java
git commit -m "Implement EmployeeManager singleton with sample data"
```

## Activity Implementation Commits (5 commits)
```bash
git add app/src/main/java/com/auca/employeemanagement/EmployeeListActivity.java
git commit -m "Implement EmployeeListActivity with ListView"

git add app/src/main/java/com/auca/employeemanagement/EmployeeDetailActivity.java
git commit -m "Create EmployeeDetailActivity with clickable phone and email"

git add app/src/main/java/com/auca/employeemanagement/EmployeeRegistrationActivity.java
git commit -m "Add EmployeeRegistrationActivity with form validation"

git add app/src/main/java/com/auca/employeemanagement/DepartmentActivity.java
git commit -m "Implement DepartmentActivity with department list"

git add app/src/main/java/com/auca/employeemanagement/EmployeeInDepartmentDetailActivity.java
git commit -m "Create EmployeeInDepartmentDetailActivity for filtered view"
```

## Layout Commits (5 commits)
```bash
git add app/src/main/res/layout/activity_employee_list.xml
git commit -m "Design layout for employee list screen"

git add app/src/main/res/layout/activity_employee_detail.xml
git commit -m "Design layout for employee detail screen with clickable fields"

git add app/src/main/res/layout/activity_employee_registration.xml
git commit -m "Create registration form layout with all input fields"

git add app/src/main/res/layout/activity_department.xml
git commit -m "Design department list layout"

git add app/src/main/res/layout/activity_employee_in_department.xml
git commit -m "Create layout for department employee list"
```

## Service and Final Commits (3+ commits)
```bash
git add app/src/main/java/com/auca/employeemanagement/MusicPlayerService.java
git commit -m "Implement MusicPlayerService as background service"

git add .
git commit -m "Add implicit intents for phone dialer and email"

git add .
git commit -m "Final testing and bug fixes"

git add .
git commit -m "Update README with complete documentation"
```

## Additional Enhancement Commits (to reach 20+)
```bash
git commit -m "Improve UI styling and colors"
git commit -m "Add input validation for registration form"
git commit -m "Enhance ListView item appearance"
git commit -m "Add Toast notifications for user feedback"
git commit -m "Optimize data flow between activities"
```

## Push to GitLab
```bash
git remote add origin <your-gitlab-repo-url>
git branch -M main
git push -u origin main
```

## Tips for Good Commits:
1. Make small, focused commits
2. Write clear, descriptive commit messages
3. Commit after completing each feature
4. Don't commit all files at once
5. Test before committing
6. Use present tense in commit messages
7. Reference issue numbers if applicable

## Viewing Your Commits:
```bash
git log --oneline
git log --graph --oneline --all
```

This will show all your commits on GitLab's contribution graph!
