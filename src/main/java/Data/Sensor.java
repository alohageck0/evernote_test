package Data;

public class Sensor {
   private String id, type, group, name;

   public Sensor(String id, String type, String group, String name) {
      this.id = id;
      this.type = type;
      this.group = group;
      this.name = name;
   }

   public String getId() {
      return id;
   }

   public String getType() {
      return type;
   }

   public String getGroup() {
      return group;
   }

   public String getName() {
      return name;
   }
}
