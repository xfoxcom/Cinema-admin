import java.util.Scanner;


    public class Cinema {

        public static void main(String[] args) {

            // Hello fromIDE
            Scanner scr = new Scanner(System.in);

            System.out.println("Enter the number of rows: ");
            int numR = scr.nextInt();
            System.out.println("Enter the number of seats in each row: ");
            int numS = scr.nextInt();

            char[][] cinema = new char[numR][numS];

            for (int i = 0; i < cinema.length; i++) {
                for (int j = 0; j < cinema[i].length; j++) {
                    cinema[i][j] = 'S';
                }
            }

            int i;
            do {
                System.out.println("1. Show the seats \n2. Buy a ticket \n3.Statistics \n0.Exit");
                i = scr.nextInt();
                if (i==1) showSeats(cinema, numS);
                if (i==2) buyTicket(numR,numS,cinema);
                if (i==3) Statistics(cinema, numR, numS);

            } while (i!=0);
        }


        public static void Statistics(char[][] cinema, int numR, int numS) {
            int sumPrice=0, currInc=0, sum=0;
            for (int i = 0; i < cinema.length; i++) {
                for (int j = 0; j < cinema[i].length; j++) {
                    if (cinema[i][j] == 'B') sum++;
                }
            }
            System.out.println("Number of purchased tickets: " + sum);

            float x = (float) sum/(numS*numR)*100;
            System.out.println("Percentage: " + String.format("%.2f",x) + "%");

            int [][] kino = new int[numR][numS];

            for (int i = 0; i< cinema.length; i++){
                for (int j = 0; j<cinema[i].length; j++){

                    if (numR*numS<60) {
                        kino[i][j] = 10;
                    }

                    if (numR==7 && numR*numS>60 && i>2) {
                        kino[i][j]=8;
                    }

                    if (i>3 && numR*numS>60 && numR!=7) {
                        kino[i][j]=8;
                    }

                    if (numR==7 && i<=2 && numR*numS>60) {
                        kino[i][j] = 10;
                    }
                    if (numR!=7 && i<=3 && numR*numS>60) {
                        kino[i][j] = 10;
                    }

                    sumPrice = sumPrice + kino[i][j];
                }
            }

            for (int i = 0; i < cinema.length; i++) {
                for (int j = 0; j < cinema[i].length; j++) {
                    if (cinema[i][j] == 'B') currInc = currInc + kino[i][j];
                }
            }

            System.out.println("Current income: $" + currInc);
            System.out.println("Total income: " + "$" +sumPrice);
        }

        public static void showSeats(char[][] cinema, int numS) {

            System.out.println("Cinema:");
            System.out.print(" ");
            for (int i = 1; i <= numS; i++) {
                System.out.print(" "+i);
            }
            System.out.println();
            for (int i = 0; i < cinema.length; i++) {
                System.out.print(i+1 + " ");
                for (int j = 0; j < cinema[i].length; j++) {
                    System.out.print(cinema[i][j] + " ");
                }
                System.out.println();
            }
        }


        public static void buyTicket(int numR, int numS, char[][] cinema) {
            Scanner scr = new Scanner(System.in);
            int rN, sN, price=0;
            boolean chSeat = true;
            do {
                System.out.println("Enter a row number: ");
                rN = scr.nextInt();
                System.out.println("Enter a seat number in that row: ");
                sN = scr.nextInt();
                chSeat=true;
                if (rN < 0 || rN > numR || sN < 0 || sN > numS) {
                    System.out.println("Wrong input!");
                }

                for (int i = 0; i < numR; i++) {
                    for (int j = 0; j < numS; j++) {
                        if (cinema[i][j] == 'B' && i == rN-1 && j == sN-1) {
                            chSeat = false;
                            System.out.println("That ticket has already been purchased!");
                        }
                    }
                }
            } while ((rN < 0 || rN > numR) || (sN < 0 || sN > numS) || !chSeat);

            int [][] kino = new int[numR][numS];

            for (int i = 0; i< cinema.length; i++){
                for (int j = 0; j<cinema[i].length; j++){

                    if (numR*numS<60) {
                        kino[i][j] = 10;
                    }

                    if (numR==7 && numR*numS>60 && i>2) {
                        kino[i][j]=8;
                    }

                    if (i>3 && numR*numS>60 && numR!=7) {
                        kino[i][j]=8;
                    }

                    if (numR==7 && i<=2 && numR*numS>60) {
                        kino[i][j] = 10;
                    }
                    if (numR!=7 && i<=3 && numR*numS>60) {
                        kino[i][j] = 10;
                    }

                }
            }

            for (int i =0; i<numR; i++){
                for (int j =0; j < numS; j++){
                    if (i == rN-1 && j == sN-1) {
                        price = kino[i][j];
                        cinema[i][j] = 'B';
                    }
                }
            }

            System.out.println("Ticket price: " + "$" + price);
        }

    }

