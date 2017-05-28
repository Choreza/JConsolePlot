# JConsolePlot
JConsolePlot is an application to draw directly in the command line different kind of graphics. You can easily draw a lot bar graphics or scatter graphics by console, using information from a file or just giving it in the command line.
![ScatterPlot](https://github.com/Choreza/JConsolePlot/blob/master/src/img/scatterplot-ex.png)
![BarPlot](https://github.com/Choreza/JConsolePlot/blob/master/src/img/barplot-ex.png)

## 1 Preparatives.

### 1.1 Download the repository in your computer.
Create a new folder for JConsolePlot and download the files of the repository inside it.

### 1.2 Open eclipse and set the build-path 
This aplication uses external libraries, so you must manually set the classpath in your editor, click [here](src/guide/buildpath.md) to know how to do this in Eclipse.

## 2 Start Guide.

### 2.1 Options to draw.
First of all, to draw some graphic you must choose a kind of graphic, it could be an **BarPlot** or a **ScatterPlot**, and give some input to the application, it could be from a file using the option **-F** followed by the path to the file, or directly by the command line using the option **-P** followed the different tuples separated by **,** (ex: *3,4 1,7 12,4*). You can also set the maximum value of the axes by using options **-x** and **-y** (note: -x only works in ScatterPlot, has no sense to set the maximum value of the horizontal axe in a bar graphic).

#### 2.1.1 Bar Plot
Draw bar graphics using this option, the bars will appear in the order you give the information. If the lenght of the name of a bar is greater than 3, the word will be abbreviated. You must give the information as a tuple *(x,y)* where *x* could be a random string, and *y* is necesarilly an integer representative of a frequency.

#### 2.1.2 Scatter Plot
Draw scatter graphics using this option, the points will be distributed in the graphic, setting the minimum value of the axes as the minimum value of the coordinates given as input. You must give the information as a tuple *(x,y)* where *x* and *y* are both coordinates of a cartesian plane.
