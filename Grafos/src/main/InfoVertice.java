package main;

public class InfoVertice {

private String info;

public InfoVertice(String info) {
	super();
	this.info = info;
}

public String getInfo() {
	return info;
}

public void setInfo(String info) {
	this.info = info;
}

@Override
public String toString() {
	return "InfoVertice [info=" + info + "]";
}

}
