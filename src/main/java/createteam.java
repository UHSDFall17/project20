import java.io.*;
import java.util.Scanner;

public class createteam {

    public static void editTeam(){
        String [] teams = new String[100];
        System.out.println("Select a team to edit: ");
        boolean found = false;
        FileReader fr = null;
        try {
            fr = new FileReader("DB.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            int i = 0;

            while ((str = br.readLine()) != null) {
                if (str.equals("ID: " + Main.inpUser))
                    found = true;
                if (found == true && str.contains("Team Name: ")) {
                    String[] parts = str.split(": ");
                    teams[i] = parts[1];
                    i++;
                    System.out.println(i+")"+parts[1]);
                }
                if (found == true && str.length() == 0)
                    break;
            }
            br.close();
            if (found == false)
                System.out.println("Teams not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        displayTeamProfile(teams[op-1]);
        System.out.println("Select the option to be editied:");
        System.out.println("===========================================");
        System.out.println("|              MENU SELECTION             |");
        System.out.println("===========================================");
        System.out.println("| Options:                                |");
        System.out.println("|        1. Website                       |");
        System.out.println("|        2. Description                   |");
        System.out.println("|        3. Add Member                    |");
        System.out.println("|        4. Remove Member                 |");
        System.out.println("|        5. Cancel                        |");
        System.out.println("===========================================");
        int value = sc.nextInt();
        // Switching on the value given from user
        switch (value) {

            case 1:
                System.out.println("Enter the new Website:");
                Scanner css = new Scanner(System.in);
                String wsite = css.nextLine();
                String oldFileName = "teamprofile.txt";
                String tmpFileName = "tmp_try.txt";
                boolean f = false;
                boolean ft = false;
                BufferedReader br = null;
                BufferedWriter bw = null;
                try {
                    br = new BufferedReader(new FileReader(oldFileName));
                    bw = new BufferedWriter(new FileWriter(tmpFileName));
                    String line;

                    while ((line = br.readLine()) != null) {
                        if(line.equals("Name: " + teams[op-1] + " Admin: " + Main.inpUser))
                            f=true;
                        if (f==true && line.contains("Website:"))
                        {
                            line = line.replace(line, "Website: "+wsite);
                            f=false;
                        }
                        System.out.println(line);
                        bw.write(line+"\n");
                    }
                } catch (Exception e) {
                    //  return;
                } finally {
                    try {
                        if(br != null)
                            br.close();
                    } catch (IOException e) {
                        //
                    }
                    try {
                        if(bw != null)
                            bw.close();
                    } catch (IOException e) {
                        //
                    }
                }
                // Once everything is complete, delete old file..
                File oldFile = new File(oldFileName);
                oldFile.delete();

                // And rename tmp file's name to old file name
                File newFile = new File(tmpFileName);
                newFile.renameTo(oldFile);
                break;
            case 2:
                System.out.println("Enter the new Description:");
                Scanner cs = new Scanner(System.in);
                String desc = cs.nextLine();
                String oFName = "teamprofile.txt";
                String tFName = "tmp_try.txt";
                boolean frr= false;
                BufferedReader brr = null;
                BufferedWriter bww = null;
                try {
                    brr = new BufferedReader(new FileReader(oFName));
                    bww = new BufferedWriter(new FileWriter(tFName));
                    String line;

                    while ((line = brr.readLine()) != null) {
                        if(line.equals("Name: " + teams[op-1] + " Admin: " + Main.inpUser))
                            frr=true;
                        if (frr==true && line.contains("Description:"))
                        {
                            line = line.replace(line, "Description: "+desc);
                            frr=false;
                        }
                        bww.write(line+"\n");
                    }
                } catch (Exception e) {
                    //  return;
                } finally {
                    try {
                        if(brr != null)
                            brr.close();
                    } catch (IOException e) {
                        //
                    }
                    try {
                        if(bww != null)
                            bww.close();
                    } catch (IOException e) {
                        //
                    }
                }
                // Once everything is complete, delete old file..
                File oFile = new File(oFName);
                oFile.delete();

                // And rename tmp file's name to old file name
                File nFile = new File(tFName);
                nFile.renameTo(oFile);
                break;
            case 3:
                //we call this function to add members to the textfile.
                addMembers(teams[op-1]);
                break;
            case 4:
                System.out.println("Enter the id of the member to be removed:");
                String rname = sc.next();
                String oame = "teamprofile.txt";
                String tame = "tmp_try.txt";
                boolean rrf= false;
                BufferedReader rrb = null;
                BufferedWriter wwb = null;
                try {
                    rrb = new BufferedReader(new FileReader(oame));
                    wwb = new BufferedWriter(new FileWriter(tame));
                    String line;

                    while ((line = rrb.readLine()) != null) {
                        if(line.equals("Name: " + teams[op-1] + " Admin: " + Main.inpUser))
                            rrf=true;
                        if (rrf==false || !line.equals(rname))
                        {
                            wwb.write(line+"\n");
                        }
                    }
                } catch (Exception e) {
                    //  return;
                } finally {
                    try {
                        if(rrb != null)
                            rrb.close();
                    } catch (IOException e) {
                        //
                    }
                    try {
                        if(wwb != null)
                            wwb.close();
                    } catch (IOException e) {
                        //
                    }
                }
                // Once everything is complete, delete old file..
                File oile = new File(oame);
                oile.delete();

                // And rename tmp file's name to old file name
                File nile = new File(tame);
                nile.renameTo(oile);
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid selection");
                break;

        }// End of switch statement
    }

    public static boolean displayTeam() {
        String[] teams = new String[100];
        boolean foun = false;
        FileReader fr = null;
        try {
            fr = new FileReader("DB.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            int i = 0;

            while ((str = br.readLine()) != null) {
                if (str.equals("ID: " + Main.inpUser))
                    foun = true;
                if (foun == true && ((str.contains("Team Name: ")) || str.contains("Name: "))) {
                    String[] parts = str.split(": ");
                    teams[i] = parts[1];
                    i++;
                    System.out.println(i + ")" + parts[1]);
                }
                if (foun == true && str.length() == 0)
                    break;
            }
            br.close();
            if (foun == false)
                System.out.println("Teams not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Select a team for details:");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        displayTeamProfile(teams[s-1]);

        return foun;
    }



    public static boolean displayTeamProfile(String tname){
        boolean found = false;
        FileReader fr = null;
        try {
            fr = new FileReader("teamprofile.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.contains("Name: " + tname))
                    found = true;
                if (found == true) {
                    System.out.println(str);
                    if (str.length() == 0)
                        break;
                }
            }
            br.close();
            if (found == false)
                System.out.println("Team not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }
    public static boolean addMembers(String teamname) {
        System.out.println("Enter the ID of the member to be added");
        Scanner sc = new Scanner(System.in);
        String idname = sc.next();
        String oldFileName = "DB.txt";
        String tmpFileName = "tmp_try.txt";
        boolean f = false;
        boolean ft = false;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));
            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line+"\n");
                if (line.equals("ID: " + idname))
                {
                    f = true;
                    ft = true;
                }
                if (f == true && line.equals("Non Admin Teams:")) {
                    bw.write("Name: " + teamname + "\n");
                    f = false;
                }
            }
        } catch (Exception e) {
          //  return;
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                //
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(oldFileName);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);

        if(ft == true) {
            String ofn = "teamprofile.txt";
            String tfn = "tmp_try.txt";

            BufferedReader bvr = null;
            BufferedWriter bwr = null;
            try {
                bvr = new BufferedReader(new FileReader(ofn));
                bwr = new BufferedWriter(new FileWriter(tfn));
                String line;
                boolean fl = false;
                while ((line = bvr.readLine()) != null) {
                    bwr.write(line + "\n");
                    if (line.equals("Name: " + teamname + " Admin: " + Main.inpUser))
                        fl = true;
                    if (fl == true && line.equals("Members:")) {
                        bwr.write(idname + "\n");
                        fl = false;
                    }
                }
            } catch (Exception e) {
                //  return;
            } finally {
                try {
                    if (bvr != null)
                        bvr.close();
                } catch (IOException e) {
                    //
                }
                try {
                    if (bwr != null)
                        bwr.close();
                } catch (IOException e) {
                    //
                }
            }
            // Once everything is complete, delete old file..
            File oldFilen = new File(ofn);
            oldFilen.delete();

            // And rename tmp file's name to old file name
            File newFilen = new File(tfn);
            newFilen.renameTo(oldFilen);
        }
        else
            System.out.println("ID not found");
        return true;
    }
    //following function is for creating a Team in trello.
    static void CreateATeam() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("teamprofile.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //taking basic team profile information and storing it in a text file.
        PrintWriter pw = new PrintWriter(fw);
        Scanner sc = new Scanner(System.in);
        pw.println();
        System.out.println("Enter Name of the Team:");
        String name = sc.nextLine();
        pw.println("Name: " + name + " Admin: " + Main.inpUser);
        System.out.println("Enter Website:");
        String site = sc.nextLine();
        pw.println("Website: " + site);
        System.out.println("Enter Description:");
        String desc = sc.nextLine();
        pw.println("Description: " + desc);
        pw.println("Members:\n" + Main.inpUser);
        pw.close();


        String oldFileName = "DB.txt";
        String tmpFileName = "tmp_try.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));
            String line;
            boolean f = false;
            while ((line = br.readLine()) != null) {
                bw.write(line+"\n");
                if (line.equals("ID: " + Main.inpUser))
                    f = true;
                if (f == true && line.equals("Admin Teams:")) {
                    bw.write("Team Name: " + name+"\n");
                    f = false;
                }

            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                //
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(oldFileName);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);

        //Taking menu options from the user
        int value;
        String[] names = new String[100];
        int mem;
        //displaying menu
        do {
            System.out.println("===========================================");
            System.out.println("|              MENU SELECTION             |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Display Team Profile          |");
            System.out.println("|        2. Display existing Boards       |");
            System.out.println("|        3. Add Member                    |");
            System.out.println("|        4. Add Board                     |");
            System.out.println("|        5. Remove Board                  |");
            System.out.println("|        6. Exit                          |");
            System.out.println("===========================================");
            value = sc.nextInt();
            // Switching on the value given from user
            switch (value) {

                case 1:
                    //when user selects option 1 it shows the profile of the created team using the following function.
                    displayTeamProfile(name);
                    break;
                case 2:
                    System.out.println("Boards from harshit code");
                    break;
                case 3:
                    //we call this function to add members to the textfile.
                    addMembers(name);
                    break;
                case 4:
                    System.out.println("Add board from harshit code");
                    break;
                case 5:
                    System.out.println("remove from the file of boards");
                    break;
                case 6:
                    System.out.println("Exit selected");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;

            }// End of switch statement

        } while (value != 6);
    }
}
