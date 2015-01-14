// U30503758
// Jason Maynard
// Operating Systems, Summer '14

package osp.Threads;
import java.util.Vector;
import java.util.Enumeration;
import osp.Utilities.*;
import osp.IFLModules.*;
import osp.Tasks.*;
import osp.EventEngine.*;
import osp.Hardware.*;
import osp.Devices.*;
import osp.Memory.*;
import osp.Resources.*;

/**
 This class is responsible for actions related to threads, including
 creating, killing, dispatching, resuming, and suspending threads.
 */
public class ThreadCB extends IflThreadCB
{
    /**
     The thread constructor.
     */
    public ThreadCB()
    {
        super(); // calls constructor of parent class
        System.out.println("\nTaskCB() constructor called...");
    }

    /**
     This method will be called once at the beginning of the
     simulation. The student can set up static variables here.
     */
    public static void init()
    {
        // This method intentionally left blank

    }

    /**
     Sets up a new thread and adds it to the given task.
     The method must set the ready status
     and attempt to add thread to task. If the latter fails
     because there are already too many threads in this task,
     so does this method, otherwise, the thread is appended
     to the ready queue and dispatch() is called.

     The priority of the thread can be set using the getPriority/setPriority
     methods. However, OSP itself doesn't care what the actual value of
     the priority is. These methods are just provided in case priority
     scheduling is required.

     @return thread or null
     */
    static public ThreadCB do_create(TaskCB task)
    {
        ThreadCB theThread = new ThreadCB();

        return null;
    }

    /**
     Kills the specified thread.

     The status must be set to ThreadKill, the thread must be
     removed from the task's list of threads and its pending IORBs
     must be purged from all device queues.

     If some thread was on the ready queue, it must removed, if the
     thread was running, the processor becomes idle, and dispatch()
     must be called to resume a waiting thread.
     */
    public void do_kill()
    {
        // *** your code goes here ***

    }

    /** Suspends the thread that is currently on the processor on the
     specified event.

     Note that the thread being suspended doesn't need to be
     running. It can also be waiting for completion of a page fault
     and be suspended on the IORB that is bringing the page in.

     Thread's status must be changed to ThreadWaiting or higher,
     the processor set to idle, the thread must be in the right
     waiting queue, and dispatch() must be called to give CPU
     control to some other thread.

     @param event - event on which to suspend this thread.
     */
    public void do_suspend(Event event)
    {
        // *** your code goes here ***
    }

    /** Resumes the thread.

     Only a thread with the status ThreadWaiting or higher
     can be resumed.  The status must be set to ThreadReady or
     decremented, respectively.
     A ready thread should be placed on the ready queue.
     */
    public void do_resume()
    {
        // *** your code goes here ***
    }

    /**
     Selects a thread from the run queue and dispatches it.

     If there is just one thread ready to run, reschedule the thread
     currently on the processor.

     In addition to setting the correct thread status it must
     update the PTBR.

     @return SUCCESS or FAILURE
     */
    public static int do_dispatch()
    {
        // Insert awesome scheduling algorithm here
        // Target multi-level feedback queue
        // - Need to first implement FCFS and Round-Robbin building blocks

        // MLFS defined by (Pg. 276 text)
        // - Number of queues
        // - Scheduling alg for each queue
        // - Methods to determine promotion and demotion
        // - Method used to determine which queue a process will enter
        //   when that process needs service

        return 0;
    }

    /**
     Called by OSP after printing an error message. The student can
     insert code here to print various tables and data structures in
     their state just after the error happened.  The body can be
     left empty, if this feature is not used.
     */
    public static void atError()
    {
        System.out.println("I am atError()");
    }

    /** Called by OSP after printing a warning message. The student
     can insert code here to print various tables and data
     structures in their state just after the warning happened.
     The body can be left empty, if this feature is not used.
     */
    public static void atWarning()
    {
        System.out.println("I am atWarning()");
    }

} // end ThreadCB