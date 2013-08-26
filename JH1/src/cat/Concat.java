package cat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Concat {
	
	public void checkFileType(String filename)
	{
		String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
		
    	if (extension.equals("java") || extension.equals("txt")) {
    		return;
    	} else {
    		throw new RuntimeException("Input files for Concat must have either a .java or .txt suffix: " + filename);
    	}	
	}
    
    public void copy(InputStream is, PrintStream ps)
    {
      // Create a Scanner class from "is" and copy contents to "ps"
    	InputStreamReader myReader = new InputStreamReader(is);
    	BufferedReader myIn = new BufferedReader(myReader);
    	
    	try {
			
			while(myIn.ready()) {
				String str = myIn.readLine();
				ps.println(str);
			}
		} catch (IOException e) {
			System.out.println("File Not Found Exception in copy");
			e.printStackTrace();
		}
    }
    
    void concat(String[] inFiles,  int numInputs, String outFile) 
    {
    	
    if (outFile == null)
    {
    	if (numInputs == 0) {
    		Scanner keyboard = new Scanner(System.in);
    		String output = keyboard.next();
    		System.out.println(output);
    		keyboard.close();
    	} else {
    		checkFileType(inFiles[0]);
    		File f = new File(inFiles[0]);
    		PrintStream ps;
    		FileInputStream fis = null;
    		//Scanner input = null;
    		try {
    			fis = new FileInputStream(f);
    			ps = new PrintStream(System.out);
    			copy(fis, ps);
    			/* Alternative use case, using Scanner class
        		input = new Scanner(f);
        		while (input.hasNextLine())
                {
                    String s = input.nextLine();
                    System.out.println(s);
                }
                input.close();
                */
        	} catch (FileNotFoundException e) {
        		System.out.println("The input file is not found, defaulting to reading from keyboard");
        		concat(inFiles, 0, null);
        	}
    		finally
	        {
	                try {
	                    fis.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	        }
    	}
    } 
    else
    {
    	File fo = new File(outFile);
    	checkFileType(outFile);
    	PrintStream ps;
		try {
			ps = new PrintStream(fo);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			throw new RuntimeException("Cannot create output file, aborting");
		}
    		
	    for (int i = 0; i < inFiles.length - 1; i++ )
	    {
	    	checkFileType(inFiles[i]);
	    	File f = new File(inFiles[i]);
	    	FileInputStream fis = null;
	    	try {
	            //Scanner scan = new Scanner(f);
	    		fis = new FileInputStream(f);
	    		copy(fis, ps);
	    		/* Alternative use case using Scanner class
		    	while (scan.hasNextLine())
	            {
	                String s = scan.nextLine();
	                ps.println(s);
	            }
		    	
		    	scan.close();
				*/
	    	} catch (FileNotFoundException e) {
	            System.out.println(" Error: "+e + " "+ inFiles[i]);
	            e.printStackTrace();
	    	}
	    	finally
	        {
	                try {
	                    fis.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	        }
	    }
	    
        ps.close();
    
    }
    // if outFile = = null, or "outFile" can't be opened then write output the screen.  
    //     otherwise, create an output file associated with the name "outFile"
    
    // Using your "copy" routine defined above, copy "numInputs" of files from the inFiles array to your 
    // output file (or screen)
    
    // If any of the input files can't be opened, throw a RuntimeException with a message like:
    //  "Unable to open: file_1.txt
    
    // All input files should have a suffix of either ".java" or ".txt".  If a file is found without one of these 2
    //      suffixes, throw a RuntimeException with a message like:
    //      ("Input files for Concat must have either a .java or .txt suffix: file_1.bad"
    // Don't forget to close your input and output files at appropriate places. 
                                
    }
  
    
    public void process(String[] args)
    {
     switch(args.length)
       {
       case 0:
           System.out.println("No input files, defaulting to reading from the keyboard and writing to the screen");
           concat(args, 0, null);
           break;
       case 1:
           System.out.println("No output file, defaulting to writing to the screen");
           concat(args,  1, null);
           break;
       default:
           concat(args,  args.length-1, args[args.length-1]);
           break;
       }    
    }
    

    public static void main(String[] args) {
    		
        Concat concat = new Concat();
        try
        {
            concat.process(args);
        }
        catch (RuntimeException e)
        {
            // Possible errors:
            // An input file that doesn't end with .java or .txt
            // An input file that doesn't open properly.
            // Trouble creating the output file
            
            System.out.println(" Error in Concat:"+e);
        }
    }

}