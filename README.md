# How to import it to your project
#### 1. Add the library
File, New, New module, Import .JAR/.AAR Package, Click at select package (you can choose a name for the library added), and Finish
Check in your setting's gradle if it auto added the library
![Settings' gradle](./images/1.png?raw=true)
### 2. Add dependencies
Add to your project's gradle (change 'DotLineRecyclerView' if you changed the name before)

    dependencies {
        compile project(":DotLineRecyclerView")
        compile 'com.android.support:recyclerview-v7:25.1.0'
    }

# How to use
First of all, you hace to declare a DotLineRecyclerView item at your layout.
Advice: Remove parent's margins
Bind it to your view

    DotLineRecyclerView recyclerView = (DotLineRecyclerView) findViewById(R.id.recyclerView);
In order to create recycler's items, you must create an ArrayList<RecyclerData>
Now, you need to create your adapter, that must extends from DotLineRecyclerAdapter
You must implement at least a constructor.
Bind it to your view, and set as arguments your ArrayList<RecyclerData>
Set to the RecyclerView your adapter and a LinearLayoutParams

    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
Congratulations, you did a simple dot list

# Personalization
### RecyclerData
It is items contained by our Recycler
It has 8 constructors
    These four constructors just differ in the way the photo is passed
    You can pass an URL, that will be showed and cached with Picasso
    You can pass a resource
    You can pass a Drawable
    Or you can pass no image
    
    public RecyclerData(String imageUrl, String title, String subtitle)
    public RecyclerData(int imageResource, String title, String subtitle)
    public RecyclerData(Drawable image, String title, String subtitle)
    public RecyclerData(String title, String subtitle)
    
These four constructor work the same way, but you can pass an integer id
This id will be used in your adapter if you pass an ArrayList with colors (more information in the following section

    public RecyclerData(String imageUrl, String title, String subtitle, int idColor)
    public RecyclerData(int imageResource, String title, String subtitle, int idColor)
    public RecyclerData(Drawable image, String title, String subtitle, int idColor)
    public RecyclerData(String title, String subtitle, int idColor)

### Adapter
##### Constructor
DotLineRecyclerAdapter has 4 overridable constructors that can personalizate where is the line positioned (margin left) and you can pass an ArrayList with colors to set dot  border if your RecyclerData item has and id.
Simplest constructor

    public DotLineRecyclerAdapter(ArrayList<RecyclerData> data)

colorList has a list of colors. If data items has an id (id's item == list's item position) it will set the dot border color with the color of the list

    public DotLineRecyclerAdapter(ArrayList<RecyclerData> data, ArrayList<Integer> colorList)
    public DotLineRecyclerAdapter(ArrayList<RecyclerData> data, int dotMarginLeft)
    public DotLineRecyclerAdapter(ArrayList<RecyclerData> data, int dotMarginLeft, ArrayList<Integer> colorList)

##### Overridable methods
You can change attributes overriding methods, for example
Original:

    @Override
    public int getDotBoderColor() {
        return super.getDotBoderColor();
    }

Overridden:

    @Override
    public int getDotBoderColor() {
        return Color.RED;
    }

Overridable methods:

    int getDotBorderColor()
    int getDotBorderSize()
    int getDotColor()
    int getDotSize()
    int getImageError() //If you are using items with image urls, you can set an image is not loaded (using picasso)
    int getMessageBackground() //You can set the image used as message's background
    int getMessageBackgroundPressed() //You can set the image used as message's background when user press it (only below Lollipop)
    int getSeparator() //Separations between items
    int getTextSubtitleColor()
    int getTextSubtitleSize()
    int getTextTitleColor()
    int getTextTitleSize()
    
### DotLineRecyclerView
##### Methods

    setLineColor(int)
    setLineWidth(int)
Furthermore, you can get the recyclerview used in the component with getRecyclerView()
