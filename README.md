# PUSL3122 - HCI Group Project - Interior Design Application

![App Icon]([assets/icon.png](https://github.com/chamod4915/PUSL3122_HCI/blob/main/Images/Capture5555.PNG))

## Overview
This project is a desktop-based interior design application developed as part of the PUSL3122 module (Human-Computer Interaction, Computer Graphics, and Visualization) at the University of Plymouth. The application is designed for a furniture design company to assist in-store designers in creating customized room layouts using 2D components and visualizing them in 3D.

![Dashboard](assets/dashboard.png)

## Features
- 🛠️ Input room dimensions and shapes
- 🛋️ Arrange furniture objects using 2D components
- 🖼️ 3D visualization of furniture arrangements
- 🎨 Scale, color, and shade customization for objects
- 💾 Save and load design projects
- 🖱️ Interactive user interface using Java Swing and JavaFX

![3D View](assets/3d_view.png)

## Technology Stack
- Java Swing - UI Development
- JavaFX - 3D Visualization
- File-based Serialization - Data Storage
- Git - Version Control

## Project Structure
```
├── src/
│   ├── main/
│   │   └── java/
│   └── resources/
├── assets/
│   ├── icon.png
│   ├── dashboard.png
│   └── 3d_view.png
├── README.md
├── .gitignore
└── PUSL3122_Coursework_Report_Group_102.pdf
```

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/chamod4915/PUSL3122_HCI.git
   ```

2. Navigate to the project directory:
   ```bash
   cd PUSL3122_HCI
   ```

3. Compile the project:
   ```bash
   javac -d bin src/main/java/*.java
   ```

4. Run the application:
   ```bash
   java -cp bin Main
   ```

## Usage
- Launch the application and log in to access the dashboard.
- Input room dimensions and select shapes to start a new design.
- Arrange furniture items, customize colors, and preview in 3D.
- Save the design for future edits or export as an image.

## Evaluation
User testing was conducted with a sample group of in-store furniture designers. The application received positive feedback for its intuitive interface and 3D visualization capabilities. Suggestions for improvement include enhanced tooltips and real-time rotation in the 3D view.

## Future Enhancements
- 📌 Implement interactive tooltips for first-time users
- 🔄 Enable 3D object rotation using drag gestures
- ↩️ Add undo/redo functionality
- 🖨️ Support for exporting designs as PDF/PNG

## Resources
- [JavaFX 3D Graphics](https://docs.oracle.com/javase/8/javafx/graphics-tutorial/javafx-3d-graphics.htm)
- [Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Project Video Demonstration](https://youtu.be/XyjZozIutKo?si=L-xyUmC24VjQX9Hm)

## Contributors
- Henaka Kumara (10898536)
- KASB Kaluarachchi (10899574)
- GH Dulya (10899715)
- Kolamunnage Perera (10748105)
- Horadagoda Horadagoda (10899550)
- Disanayaka Muluthukumbura (10899620)

## License
This project is developed for academic purposes under the guidance of Dr. Taimur Bakhshi, University of Plymouth. All rights reserved.
