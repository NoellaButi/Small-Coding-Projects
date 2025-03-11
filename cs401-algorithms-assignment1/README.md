# Soil Water Drainage 🌱💧

This project implements the **Weighted Quick Union algorithm** to determine if **water drains through a soil grid**.

## 📌 Problem Description
A **soil sample** is represented as an **n x n grid**, where:
- `1` = allows water to drain.
- `0` = holds water.

Water starts at the **top row** and must reach the **bottom row**. The program determines whether water can pass through using **Weighted Quick Union**.

## 🛠️ Components
- **`Soil.java`** → Reads input, processes the grid, and applies **Union-Find**.
- **`WeightedQuickUnion.java`** → Implements **Weighted Quick Union with path compression**.
- **`App.java`** → Runs the program and prints `"Allows water to drain"` or `"Doesn't allow water to drain"`.

## 🔧 How to Run
1. **Compile the Java files**:
   ```bash
   javac src/*.java
