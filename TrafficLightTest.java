public class TrafficLightTest {
    public static void main(String[] args){
        //displays duration
        for(TrafficLight light: TrafficLight.values()){
            System.out.println(light + ": "+light.getDuration()+"seconds");
        }
    }
}
