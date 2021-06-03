
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
                this.columnsList.add(column);
                this.columnsList.get(0).isBasement = true;
                if (this.columnsList.get(i).isBasement == false)
                {
                    int servedFloorMin = (i - 1) * (_amountOfFloors / (this.amountOfColumns -1));
                    int servedFloorMax = i * (_amountOfFloors / (this.amountOfColumns -1));
                    int[] serverFloor = new int[]{0, servedFloorMin, servedFloorMax};
                    this.columnsList.get(i).servedFloors = serverFloor;
                } else
                {
                    int servedFloorMin = i;
                    int servedFloorMax = i - this.amountOfBasements;
                    int[] serverFloor = new int[]{0, servedFloorMin, servedFloorMax};
                    this.columnsList.get(i).servedFloors = serverFloor;
                }
            }
        }

        public void assignElevator(int _requestedFloor, String _direction){
            // create column
            createColumn(this.amountOfColumns, this.amountOfFloors, this.amountOfElevatorPerColumn);
            // create elevator
            for (int i = 0; i < this.amountOfColumns; i++)
            {
                this.columnsList.get(i).createElevator(this.amountOfFloors, this.amountOfElevatorPerColumn);
            } 
            int selectedColumnNumber = findBestColumn(_requestedFloor, this.columnsList);
            System.out.println("Colone " + selectedColumnNumber + " is selected");
            var selectedColumn = this.columnsList.get(selectedColumnNumber);
            
             // Set floor on scenario
             this.columnsList.get(1).elevatorsList.get(0).currentFloor = 20;
             this.columnsList.get(1).elevatorsList.get(1).currentFloor = 3;
             this.columnsList.get(1).elevatorsList.get(1).currentFloor = 13;
             this.columnsList.get(1).elevatorsList.get(1).currentFloor = 15;
             this.columnsList.get(1).elevatorsList.get(1).currentFloor = 6;

            // find best column

            for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
            {
                if (selectedColumn.elevatorsList.get(1).currentFloor == _requestedFloor)
                {
                    int[] floorRequestList = new int[]{_requestedFloor};
                    selectedColumn.elevatorsList.get(1).floorRequestList = floorRequestList;
                    selectedColumn.status = "busy";
                    break;
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -1 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 1)
                    {
                        int[] floorRequestList = new int[]{_requestedFloor};
                        selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                        selectedColumn.status = "busy";
                        break;
                    }
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -2 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 2)
                    {
                        int[] floorRequestList = new int[]{_requestedFloor};
                        selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                        selectedColumn.status = "busy";
                        break;
                    }
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -3 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 3)
                    {
                        int[] floorRequestList = new int[]{_requestedFloor};
                        selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                        selectedColumn.status = "busy";
                        break;
                    }
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -4 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 4)
                    {
                        int[] floorRequestList = new int[]{_requestedFloor};
                        selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                        selectedColumn.status = "busy";
                        break;
                    }
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -5 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 5)
                    {
                        int[] floorRequestList = new int[]{_requestedFloor};
                        selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                        selectedColumn.status = "busy";
                        break;
                    }
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -10 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 10)
                    {
                        int[] floorRequestList = new int[]{_requestedFloor};
                        selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                        selectedColumn.status = "busy";
                        break;
                    }
                }
            }
            if (selectedColumn.status == "online")
            {
                for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
                {
                    if (selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor >= -20 && selectedColumn.elevatorsList.get(i).currentFloor-_requestedFloor <= 20)
                    {
                         int[] floorRequestList = new int[]{_requestedFloor};
                    selectedColumn.elevatorsList.get(i).floorRequestList = floorRequestList;
                    selectedColumn.status = "busy";
                    break;
                    }
                }
            }

            /// mouvement

            for (int i = 0; i < this.amountOfElevatorPerColumn; i++)
            {
                if (selectedColumn.elevatorsList.get(i).floorRequestList.length > 0)
                {
                    selectedColumn.elevatorsList.get(i).Door.status = "closed";
                    selectedColumn.elevatorsList.get(i).status = "moving";
                    if (selectedColumn.elevatorsList.get(i).currentFloor < _requestedFloor)
                    {
                        var selectedElevator = selectedColumn.elevatorsList.get(i);
                        selectedElevator.direction = "up";
                        System.out.println("Elevator " + selectedColumn.elevatorsList.get(i).ID + " is " + selectedColumn.elevatorsList.get(i).status + ' ' + selectedColumn.elevatorsList.get(i).direction);
                        for (int x = selectedElevator.currentFloor; x < _requestedFloor; x++)
                        {
                            selectedElevator.currentFloor = selectedElevator.currentFloor + 1;
                            System.out.println("Floor : " + selectedElevator.currentFloor);
                        }
                    //// ouverture des porte    
                    selectedColumn.elevatorsList.get(i).Door.status = "opened";
                    System.out.println("The door is " + selectedColumn.elevatorsList.get(i).Door.status);    
                    }
                    else if (selectedColumn.elevatorsList.get(i).currentFloor > _requestedFloor)
                    {
                        var selectedElevator = selectedColumn.elevatorsList.get(i);
                        selectedElevator.direction = "down";
                        System.out.println("Elevator " + selectedColumn.elevatorsList.get(i).ID + " is " + selectedColumn.elevatorsList.get(i).status + ' ' + selectedColumn.elevatorsList.get(i).direction);
                        for (int x = selectedElevator.currentFloor; x > _requestedFloor; x--)
                        {
                            selectedElevator.currentFloor = selectedElevator.currentFloor - 1;
                            System.out.println("Floor : " + selectedElevator.currentFloor);
                        }   
                    //// ouverture des porte                         
                    selectedColumn.elevatorsList.get(i).Door.status = "opened";
                    System.out.println("The door is " + selectedColumn.elevatorsList.get(i).Door.status);            
                    }
                    else 
                    {
                        //// ouverture des porte                         
                        selectedColumn.elevatorsList.get(i).Door.status = "opened";
                        System.out.println("The door is " + selectedColumn.elevatorsList.get(i).Door.status);    
                    }
                }
                
            }

        }




////////////////////////////// FIND BEST COLUMN //////////////////////////////

        public static int findBestColumn(int _requestedFloor, ArrayList<Column> columnsList){
            for (int i = 0; i < columnsList.stream().count(); i++)
            {
                if (columnsList.get(i).servedFloors[1] <= _requestedFloor && columnsList.get(i).servedFloors[2] >= _requestedFloor || columnsList.get(i).servedFloors[1] >= _requestedFloor && columnsList.get(i).servedFloors[2] <= _requestedFloor)
                {      
                    int selectedColumn = i;
                    return selectedColumn;
                }
            }
            return 0;
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


////////////////////////////// Create ELEVATOR //////////////////////////////        

        public void createElevator(int _amountOfFloors, int _amountOfElevators)
        {
            for(int i = 0; i < _amountOfElevators; i++)
            {
                Elevator elevator = new Elevator(i, _amountOfFloors);
                this.elevatorsList.add(elevator);
            }
        }

////////////////////////////// requestElevator //////////////////////////////        

        public void requestElevator(int _requestedFloor, String _direction){

            for (int i = 0; i < this.amountOfElevators; i++)
            {
                if (this.elevatorsList.get(i).floorRequestList.length > 0)
                {
                    if (this.elevatorsList.get(i).currentFloor < _requestedFloor)
                    {
                        this.elevatorsList.get(i).Door.status = "closed";
                        System.out.println("The door is " + this.elevatorsList.get(i).Door.status);  
                        var selectedElevator = this.elevatorsList.get(i);
                        selectedElevator.direction = "up";
                         System.out.println("Elevator " + this.elevatorsList.get(i).ID + " is " + this.elevatorsList.get(i).status + ' ' + this.elevatorsList.get(i).direction);
                        for (int x = selectedElevator.currentFloor; x < _requestedFloor; x++)
                        {
                            selectedElevator.currentFloor = selectedElevator.currentFloor + 1;
                            System.out.println("Floor : " + selectedElevator.currentFloor);
                            int[] floorRequestList = new int[]{};
                            selectedElevator.floorRequestList = floorRequestList;                       
                        //// ouverture des porte    
                        this.elevatorsList.get(i).Door.status = "opened";
                        System.out.println("The door is " + this.elevatorsList.get(i).Door.status);  
                        }
                    }
                    else 
                    {
                        this.elevatorsList.get(i).Door.status = "closed";
                        System.out.println("The door is " + this.elevatorsList.get(i).Door.status);
                        var selectedElevator = this.elevatorsList.get(i);
                        selectedElevator.direction = "down";
                        System.out.println("Elevator " + this.elevatorsList.get(i).ID + " is " + this.elevatorsList.get(i).status + ' ' + this.elevatorsList.get(i).direction);
                        for (int x = selectedElevator.currentFloor; x > _requestedFloor; x--)
                        {
                            selectedElevator.currentFloor = selectedElevator.currentFloor - 1;
                            System.out.println("Floor : " + selectedElevator.currentFloor);
                            int[] floorRequestList = new int[]{};
                            selectedElevator.floorRequestList = floorRequestList;   
                        } 
                        //// ouverture des porte                         
                        this.elevatorsList.get(i).Door.status = "opened";
                        System.out.println("The door is " + this.elevatorsList.get(i).Door.status);       
                    }
                    
                }
                    
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
        battery1.columnsList.get(1).requestElevator(0, "down");
    }

   
    
}
  