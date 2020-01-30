# HostipalSimulator

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

## How to use

1. Open with IDE and build Maven project.

or 

Build from command line

2. Open command line 
3. Navigate to build directory
4. The program takes up to 2 Inputs:
   1. The state of patients: F, H, D, T, X 
   Separeted by comma. E.g. "D,T,D" would mean that there are 3 patients, two with Diabetes and one with Tuberculosis
   You can create as many patients as you like
   2. The drugs the patients take: As, An, I, P Note, all drugs are given to all patients
   Even if a drug is listed multiple times, it's only used once
5. Run the program with your inputs e.g. ``` java -cp hospitalSimulator.jar com.hospitalSimulator.app.Core "D,D" "I" ```
This runs the program with 2 Diabetes patients and they are treated with Insulin. 
   


