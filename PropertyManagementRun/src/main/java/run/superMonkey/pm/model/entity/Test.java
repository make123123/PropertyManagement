package run.superMonkey.pm.model.entity;

public class Test {
    private Integer id;

    private String name;

    private Integer age;

    @Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}