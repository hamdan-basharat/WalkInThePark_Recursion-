package walkinthepark_recursion;
import java.util.*;

public class WalkInThePark_Recursion {
  public static void main(String[] args) {
    PathHamdan obj1 = new PathHamdan();
  }
}
class PathHamdan {
  private int[][] park;
  private boolean hasPath;
  PathHamdan() {
    int[][] tempPark = { {1, 1, 1, 0, 0}, //This is the 'park' the program travels
                         {0, 0, 1, 0, 0},
                         {1, 1, 1, 0, 0},
                         {1, 0, 0, 0, 0},
                         {1, 1, 1, 1, 1}};
    park = new int[tempPark.length][tempPark[0].length];
    setPark(tempPark);
    displayPark();                          
    pathfinder(0,0);                       
    if (hasPath)                            
    {
      System.out.println("Made it through the park");
    }
    else                                   
    {
      System.out.println("No way across the park");
    }
    displayPark();                         
  } 
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: none
 * @return: int[][] park
 *********************************************** */
  public int[][] getPark()
  {
    return park;
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: int Q, int R
 * @return: int[][] park
 *********************************************** */
  public int getPark(int Q, int R)
  {
    return park[Q][R];
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: int[][] S
 * @return: 
 *********************************************** */
  public void setPark(int[][] S)
  {
   for (int c = 0; c < S.length; c++)
   {
     for (int d = 0; d < S[0].length; d++)
     {
       getPark()[c][d] = S[c][d];
     }
   }
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: int T, int U, int V
 * @return: 
 *********************************************** */
  public void setPark(int T, int U, int V)
  {
   park[T][U] = V; 
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: 
 * @return: hasPath
 *********************************************** */
  public boolean getHasPath()
  {
    return hasPath;
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: boolean W
 * @return:
 *********************************************** */
  public void setHasPath(boolean W)
  {
    hasPath = W;
  } 
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: 
 * @return:
 *********************************************** */
  public void displayPark()
  {
    for (int a = 0; a < park.length; a++)         
    {
      for (int b = 0; b < park[0].length; b++) 
      {
          System.out.print(park[a][b] + " ");       
      }
      System.out.printf("%n");                       
    }
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: int A, int B
 * @return:
 *********************************************** */
  public void pathfinder(int A, int B)
  {
    int length = getPark().length; 
   if ( (B == (getPark()[0].length - 1)) && (A == (getPark().length - 1)) ) 
   {
     setHasPath(true);
   }
   else if (boundaryCheck(A, B,length) == 9)                        
   {
     if (A == 0 && B == 0)                                         
     {
      if (hasValidSpot(A, B+1))   
      {                            
        setPark(A,B,8);            
        pathfinder(A, B+1);
      }
     }
     else if ( hasValidSpot(A, B+1) )                           
     {
       pathfinder(A, B+1);
     }
     else                                                    
     {
       setHasPath(false);;
     }
   }
   else if (boundaryCheck(A, B,length) == 0)                 
   {                                                          
     if ( hasValidSpot(A,B+1) )         
     {                                   
       setPark(A,B,8);                  
       pathfinder(A,B+1);
     }
     else if ( hasValidSpot(A+1, B) ) 
     {                                
       setPark(A,B,8);                
       pathfinder(A+1, B);
     }
   }
   else if (boundaryCheck(A, B,length) == 1)               
   {                                                      
     if ( hasValidSpot(A, B+1) ) 
     {                           
       pathfinder(A, B+1);       
     }
     else if ( hasValidSpot(A+1, B) ) 
     {                              
       pathfinder(A+1, B);            
     }
     else if ( hasValidSpot(A-1, B) ) 
     {                                
       pathfinder(A-1, B);            
     }
   }
   else if (boundaryCheck(A,B,length) == 2)              
   {                                                    
     if ( hasValidSpot(A, B+1) )      
     {                                 
       pathfinder(A, B+1);          
     }
     else if ( hasValidSpot(A-1, B) )  
     {                                
       pathfinder(A-1, B);           
     }
   }
   else if (boundaryCheck(A,B,length) == 3)              
   {                                                   
     if ( hasValidSpot(A, B+1) )        
     {                                
       pathfinder(A, B+1);             
     }
     else if ( hasValidSpot(A+1, B) )   
     {                                  
       pathfinder(A+1, B);             
     }
     else if ( hasValidSpot(A, B-1) ) 
     {                               
       pathfinder(A, B-1);           
     }
   }
   else if (boundaryCheck(A,B,length) == 5)          
   {                                               
     if ( hasValidSpot(A, B+1) )    
     {                               
       pathfinder(A, B+1);           
     }
     else if ( hasValidSpot(A-1, B) )
     {                                
       pathfinder(A-1, B);        
     }
     else if ( hasValidSpot(A, B-1) )
     {                                
       pathfinder(A, B-1);             
     }
   }
   else if (boundaryCheck(A,B,length) == 6)          
   {                                                  
     if ( hasValidSpot(A+1, B) )        
     {                                  
       pathfinder(A+1, B);             
     }
     else if ( hasValidSpot(A, B-1) )  
     {                                
       pathfinder(A, B-1);            
     }
   }
   else if (boundaryCheck(A,B,length) == 7)          
   {                                                  
     if ( hasValidSpot(A+1, B) )   
     {                             
       pathfinder(A+1, B);       
     }
     else if ( hasValidSpot(A, B-1) )  
     {                                 
       pathfinder(A, B-1);            
     }
     else if ( hasValidSpot(A-1, B) )  
     {                                 
       pathfinder(A-1, B);           
     }
   }
   else if (boundaryCheck(A,B,length) == 4)         
   {
     if ( hasValidSpot(A, B+1) )      
     {                                
       pathfinder(A, B+1);            
     }
     else if ( hasValidSpot(A, B-1) )    
     {                                   
       pathfinder(A, B-1);               
     }
     else if ( hasValidSpot(A-1, B) )     
     {                                    
       pathfinder(A-1, B);                
     }
     else if ( hasValidSpot(A+1, B) )  
     {                                  
       pathfinder(A+1, B);           
     }
   }                                                
   else                              
   {
   hasPath = false;          
   }
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: int C, int D, int E
 * @return:
 *********************************************** */
  public int boundaryCheck (int C, int D, int E)
  {
    if (E == 1)                    
    {                             
        return 9;                 
    }                              
    else
    {
      
      if ( (C == 0) && (D == 0) )  
      {                            
        return 0;                 
      }
      else if ( (D == 0) && (C > 0) && (C < (park.length - 1)) ) 
      {                                                          
        return 1;                                                 
      }
      else if ( (C == (park.length - 1) ) && (D == 0) )          
      {                                                         
        return 2;                                                
      }
      else if ( (C == 0) && (D > 0) && (D < (park.length - 1)) )
      {                                                         
        return 3;                                              
      }
      else if ( (C == (park.length - 1) ) && (D > 0) && (D < (park.length - 1) ) ) 
      {                                                                            
        return 5;                                                                
      }
      else if ( (D == (park[0].length - 1) ) && (C == 0) ) 
      {                                                   
        return 6;                                          
      }
      else if ( (D == (park[0].length - 1) ) && (C > 0) && (C < (park.length - 1)) ) 
      {                                                                              
        return 7;                                                                   
      }
      else if ( (D == (park[0].length - 1) ) && (C == (park.length - 1) ) ) 
      {                                                                     
        return 8;                                                           
      }
      else 
      {
        return 4;
      }
    }
  }
/* ***********************************************
 * @Author: Hamdan Basharat   @Date: Nov 23, 2016
 * @param: int F, int G
 * @return: park
 *********************************************** */
  public boolean hasValidSpot(int F, int G)
  {
    if (park[F][G] == 1)             
    {                                
      park[F][G] = 8;                
      return true;
    }
    else if (park[F][G] == 0)       
    {                                
      park[F][G] = 4;                
      return false;
    }
    else                             
    {                               
      return false;                  
    }
  }
} 
