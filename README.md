# DoznakaHR

Android app designed for Hrvatske Šume. The application is supposed to replace 'pen and paper' in the forest work, that is normally used.

## What is it for..?

Without going into the specifics of the forestry activities; the app collects and stores *tree data*, and later exports that data into .xml file that can further be used.

## Built using 🛠
- [JExcel](https://www.teamdev.com/jexcel) - library to read, write, display, and modify Excel files with .xls or .xlsx formats

## How it works?

This app is designed for a sepcific use, thus inner-workings of the app are quite complex outside of forestry activities.

### Flow of data through the app ↓
- user inputs *data*
- app sorts *data* to a category based on values from local [csv](https://github.com/mkostic21/doznaka-hr/blob/master/app/src/main/res/raw/doznaka_zpz.csv) file
- app creates new .xls file and sorts *data* into rows and columns

## Preview

### Drawer Menu -> Main work screen -> sorted data preview and controll screens(x3) 
![](https://github.com/mkostic21/doznaka-hr/blob/master/screenshots/main.jpg)

### .xls Preview
![](https://github.com/mkostic21/doznaka-hr/blob/master/screenshots/doznaka-xls.png)
