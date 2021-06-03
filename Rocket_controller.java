
import java.util.ArrayList;
public class Rocket_controller {

    public static class Battery {
        public int ID;
        public String status;
        public ArrayList<Column> columnsList;
        public FloorRequestButtons[] floorRequestButtonsList; 
        public int amountOfColumns;
        public int amountOfFloors;
        public int amountOfElevatorPerColumn;
        public int amountOfBasements;

        public Battery(int _id, int _amountOfColumns, int _amountOfFloors, int _amountOfBasements, int _amountOfElevatorPerColumn){
            this.ID = _id;
            this.status = "online";
            this.columnsList = new ArrayList<Column>();
            this.floorRequestButtonsList = new FloorRequestButtons[]{};  
            this.amountOfColumns = _amountOfColumns;
            this.amountOfFloors = _amountOfFloors;
            this.amountOfElevatorPerColumn = _amountOfElevatorPerColumn;
            this.amountOfBasements = _amountOfBasements;
        }   

    
////////////////////// CREATE COLUMN ///////////////////////
        
        public void createColumn(int _amountOfColumns, int _amountOfFloors, int _amountOfElevators){
            
            for (int i = 0; i < _amountOfColumns; i++)
            {
                Column column = new Column(i, _amountOfFloors, _amountOfElevators);
                /* ArrayList<Column> column= new ArrayList<Column>(); */
                /* ArrayList<String> al= new ArrayList<String>(); */
                /* Column column = new Column(1, 4, 60); */
                this.columnsList.add(column);
                this.columnsList.get(0).isBasement = true;
                if (this.columnsList.get(i).isBasement == false)
                {
                    /* this.columnsList.get(i).servedFloors = append(this.columnsList.get(i).servedFloors, 0);
                    this.columnsList.get(i).servedFloors.add(servedFloorMin);
                    this.columnsList.get(i).servedFloors.add(servedFloorMax); */
                    int servedFloorMin = (i - 1) * (_amountOfFloors / (this.amountOfColumns -1));
                    int servedFloorMax = i * (_amountOfFloors / (this.amountOfColumns -1));
                    int[] serverFloor = new int[]{0, servedFloorMin, servedFloorMax};
                    this.columnsList.get(i).servedFloors = serverFloor;
                } else
                {
                    /* this.columnsList[i].servedFloors.Add(0);
                    this.columnsList[i].servedFloors.Add(-servedFloorMin);
                    this.columnsList[i].servedFloors.Add(servedFloorMax); */
                    int servedFloorMin = i;
                    int servedFloorMax = i - this.amountOfBasements;
                    int[] serverFloor = new int[]{0, servedFloorMin, servedFloorMax};
                    this.columnsList.get(i).servedFloors = serverFloor;
                }
                System.out.println("hellooo");
            }
        }

        public void assignElevator(int _requestedFloor, String _direction){
            // create column
            createColumn(this.amountOfColumns, this.amountOfFloors, this.amountOfElevatorPerColumn);
            
            for (int i = 0; i < this.amountOfColumns; i++)
            {
                this.columnsList.get(i).createElevator(this.amountOfFloors, this.amountOfElevatorPerColumn);

            } 
            
        }
    }

    public static class Column {
        public int ID;
        public String status;
        public int[] servedFloors; 
        public boolean isBasement;
        public ArrayList<Elevator> elevatorsList; 
        public int[] callButtonsList;
        public int amountOfElevators;


        public Column(int _id, int _amountOfFloors, int _amountOfElevators){
            this.ID = _id;
            this.status = "online";
            this.servedFloors = new int[_amountOfFloors];
            this.isBasement = false;
            this.elevatorsList = new ArrayList<Elevator>();
            this.callButtonsList = new int[]{};
            this.amountOfElevators = _amountOfElevators;
        }      

        public void createElevator(int _amountOfFloors, int _amountOfElevators)
        {
            for(int i = 0; i < _amountOfElevators; i++)
            {
                Elevator elevator = new Elevator(i, _amountOfFloors);
                this.elevatorsList.add(elevator);
            }
        }

    }

    public static class Elevator {
        public int ID;  
        public String status;
        public int currentFloor; 
        public String direction; 
        public Door Door;
        public int[] floorRequestList;   
        public int[] completedRequestsList;

        public Elevator(int _id, int _amountOfFloors){
            ID = _id;
            status = "idle";
            currentFloor = 0;
            direction = "idle";
            this.Door = new Door(_id);
            floorRequestList = new int[]{};
            completedRequestsList = new int[]{};
        }      
    }

    public static class Door {
        public int ID;
        public String status;

        public Door(int _id){
            ID = _id;
            status = "opened";
        }   
    }

    public static class CallButton {
        public int ID;
        public String status;
        public int floor;
        public String direction;

        public CallButton(int _id, int _floor, String _direction){
            ID = _id;
            status = "idle";
            floor = _floor;
            direction = _direction;
        }  
    }

    public static class FloorRequestButtons{
        public int ID;
        public String status;
        public int floor;

        public FloorRequestButtons(int _id, int _floor){
            ID = _id;
            status = "idle";
            floor = _floor;
        }  
    }
    
    public static void main(String[] args) {
        Battery battery1 = new Battery(1, 4, 60, 6, 5);
        battery1.assignElevator(10, "up");
        System.out.println(battery1.columnsList.get(1).elevatorsList.get(1).status);
    }

   
    
}
  