package lab6;

public class Supervisor implements Runnable
{
	Program prog;

	public Supervisor(Program program)
	{
		prog = program;
	}
	
	@Override
	public void run() 
	{
		Thread thread = new Thread(prog);
		thread.start();

		while(prog.getCurrentStatus() != Program.Status.FATAL_ERROR)
		{
			if ((prog.getCurrentStatus() == Program.Status.UNKNOWN) 
					|| (prog.getCurrentStatus() == Program.Status.STOPPING))
			{
				start();
			}
		}
		
		thread.interrupt();
	}
	
	public void start()
	{
		prog.setCurrentStatus(Program.Status.RUNNING);
	}

	public void stop()
	{
		prog.setCurrentStatus(Program.Status.STOPPING);
	}
}