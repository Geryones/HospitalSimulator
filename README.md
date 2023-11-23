# HospitalSimulator

A coding challenge

This little simulation allows you to create patients with different states and treat them with drugs. But be careful, if used incorrectly, some drugs have nasty side effects and can even kill patients.

Available patient states:

- F: Fever
- H: Healthy
- D: Diabetes
- T: Tuberculosis
- X: Dead

Thes drugs can be prescribed to your patients:

- As: Aspirin
- An: Antibiotic
- I: Insulin
- P: Paracetamol

Drugs behave as following: 

- Aspirin cures Fever;
- Antibiotic cures Tuberculosis;
- Insulin prevents diabetic subject from dying, does not cure Diabetes;
- If insulin is mixed with antibiotic, healthy people catch Fever;
- Paracetamol cures Fever;
- Paracetamol kills subject if mixed with aspirin;
- One time in a million the Flying Flying Spaghetti Monster shows his noodly power and resurrects a dead patient (Dead becomes Healthy).

After the simulation, a brief summary is shown. It tells you how your treatment affected the patients. 

```F:NP,H:NP,D:NP,T:NP,X:NP```

Where:

- F, H, D, T, X are patient's health status codes;
- NP is a number of patients for a given state;
- E.g. "F:0,H:2,D:0,T:0,X:1" means there are two healthy patients and one that is dead

## User guide

1. Open with IDE and build Maven project or Build from command line.
Use the Maven command package to build the project. 
With the command line: ```mvn package```
2. Open command line 
3. Navigate to build directory
4. The program takes up to 2 Inputs:
   1. The state of patients: F, H, D, T, X 
   Separeted by comma. E.g. "D,T,D" would mean that there are 3 patients, two with Diabetes and one with Tuberculosis
   You can create as many patients as you like
   2. The drugs the patients take: As, An, I, P Note, all drugs are given to all patients
   Even if a drug is listed multiple times, it's only used once
5. Run the program with your inputs e.g. ``` java -cp hospitalSimulator-1.0.jar com.hospitalSimulator.app.Core "D,D" "I" ```
This runs the program with 2 Diabetes patients and they are treated with Insulin. 
   


