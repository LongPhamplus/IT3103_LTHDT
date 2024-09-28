import java.util.Scanner;

public class StarTriangle
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Your triangle height: ");
        int n = input.nextInt();

        for (int i = 0 ; i < n ; i++)
        {
            String triangleToLine = "";
            for (int j = 0 ; j < n*2 ; j++)
            {
                if (j < n - i || j > n + i)
                {
                    triangleToLine += " ";
                }
                else
                {
                    triangleToLine += "*";
                }
            }
            System.out.println(triangleToLine);
        }
    }
}