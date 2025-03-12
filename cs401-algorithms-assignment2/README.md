# Convex Hull with Graham’s Scan 🏗️

This project implements **Graham’s Scan algorithm** to compute the **convex hull** of a set of points.

## 📌 Problem Description
The **convex hull** of `N` points is the **smallest convex polygon** that encloses all the points.  
This project:
- Uses **Graham’s Scan** to compute the convex hull.
- Provides a **GUI (`ConvexHullGUI.java`)** that allows users to **click to create points** and visualize the convex hull.

## 🛠️ Components
- **`ConvexHullBuilder.java`** → Implements **Graham’s Scan Algorithm** to compute the convex hull.
- **`ConvexHullGUI.java`** → GUI for **plotting points** and **drawing convex hulls** dynamically.
- **`App.java`** → Entry point (not required for GUI but included for extensibility).

## 🔧 How to Run
1. **Compile the Java files**:
   ```bash
   javac -cp .:lib/algs4.jar src/*.java
