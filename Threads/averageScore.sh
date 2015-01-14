#!/bin/bash

# Variable to control the number of repetitions made by the script
REPS=10

# Acumulator variable for the metric
SCORESUM=0
# Iterate REPS number of times
for i in `seq 1 $REPS`; do
	# Execute the program, no GUI
    java -classpath bin/:OSP.jar osp.OSP -noGUI

    # Parse turnaround time and CPU utilization from the log. 
    # Must be configured to make only one snapshot
    TURNAROUND=$(grep "Average service time per thread: \d*" OSP.log | grep -o "\d\+\.\d\+")
    CPUUTIL=$(grep "CPU Utilization: \d*" OSP.log | grep -o "\d\+\.\d\+")
    
    # Compute designated score
    SCORE=$(echo "$TURNAROUND+$CPUUTIL*1000" | bc)

    # Add the score to the accumulator variable
    SCORESUM=$(echo "$SCORESUM + $SCORE" | bc)
done
# Average 
FINALSCORE=$(echo "$SCORESUM / $REPS" | bc)

# Print result
echo $FINALSCORE