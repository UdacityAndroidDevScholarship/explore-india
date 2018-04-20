# explore-india
This Application is a collaborative project made by the Google Udacity Android Developer Scholars.

## Features

1) Awesome places (Location based or Interest-based)
2) Places photos
3) Famous (Food, Story, Culture, etc)
4) Giving Google Map API to give directions.
5) Place type ( Picnic, Tracking, Beach)
6) Audience (Family, Friends, Couple, etc)

When the Application is launched for the first time, The user will be sent to welcome screen to introduce app, and to get permissions (Like Location). Then, Location Access given will show famous places nearby (as per users interest) or can swipe up and have state list. If Location Access is not given, They will be showed the state/city selector activity.

In state wise view, a user in the top will get top locations in that state. Scrolling up will give user cities list, with places name in small fonts.

City participants can make their own layout for their city.

If you have any feature suggestion for Explore India App. Fill this short form [here][5].
You can add your responses multiple times.
You can read all responses [here][6]


## Google-services.json

When you compile the Application, It will give an error that google-services.json cannot be found. The file is not supposed to be added to git to avoid getting spam attacks. You can find this file in pinned messages in #cp_explore_india Channel. Put it in this path -        `\explore-india\app\google-services.json`




## Contributing

Contributions are welcome!

If you need any help, please contact us on slack at channel #cp_explore_india

1. Check out our [public issues board][0]. If your issue isn't on the board, [open a new one][1].
2. Wait for mods to assign you an issue. 
3. Fork the project ([Need help forking a project?][3]). You'll do all of your work on your forked copy.
4. Create a branch specific to the issue or feature you are working on. Push your work on that branch ([Need help with branching?][4]).
5. Name the branch something like `fixes-xxx-issue` or `add-xxx-feature` where `xxx` is a short description of the changes or feature you are adding.
6. Once your code is ready, submit a pull request from your branch to Explore India's `master` branch. We'll do a quick review and give you feedback.

[0]: https://github.com/UdacityAndroidDevScholarship/explore-india/issues
[1]: https://github.com/UdacityAndroidDevScholarship/explore-india/issues/new
[3]: https://help.github.com/articles/fork-a-repo/
[4]: https://github.com/Kunena/Kunena-Forum/wiki/Create-a-new-branch-with-git-and-manage-branches
[5]: https://goo.gl/forms/qleWaOqtXTBtCRwJ3
[6]: https://docs.google.com/spreadsheets/d/1ebKK1k8t78_CnDc_JjkvYh-lzVaY83CUSXyxPzll3qI/edit?usp=sharing



## Understanding MVP arch.

The project has a package name `base`.
It contains mainly 6 files

```
base
  - BaseActivity
  - BaseFragment
  - BaseMvpPresenter
  - BasePresenter
  - BaseView
  - PresenterFactory
```

***BaseView***
```
public interface BaseView {
.........
}
```
An base interface used to communicate with view

***BaseMvpPresenter***
```
public interface BaseMvpPresenter<V extends BaseView> {
.........
}
```
An interface used to assign view to the presenter

***BasePresenter***
```
public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

.........
}
```
A class used to connect presenter to the view

***BaseActivity***
```
public abstract class BaseActivity<T extends BaseMvpPresenter, K extends ViewDataBinding> extends AppCompatActivity implements BaseView {

.........
}
```
Our base class for the activity. It has 2 generics which connect the Databinder and presenter to this activity.

***BaseFragment***
```
public abstract class BaseFragment<T extends BaseMvpPresenter, K extends ViewDataBinding> extends Fragment implements BaseView {
.........
}
```
Our base class for the fragment. It has 2 generics which connect the Databinder and presenter to this activity.

***PresenterFactory***
```
public class PresenterFactory{
.........
}
```
This class is used to generate presenter models.



## Reason for MVP arch :
1. It creates the simplicity to write the code for Unit Testing ( Unit Testing encourages developers to modify the source code).
2. We will be able to keep track of the logic, which is inside the class.
3. Easy to divide the work.


## Accessing the System
Whenever we create a new activity. First create a package with your activity name .Remeber to create 3 main files.
(For this context I am assuming the activity name as foo)
1. FooActivity ( extend BaseActivity and should implement FooContract.View. Has view Methods)
2. FooContract ( Has the presenter and view definitions)
3. FooPresenter ( Has the presenter methods. Should implement FooContract.Presenter)

Example :
After creating you package it should look something like this.

```
foo
  - FooActivity
  - FooContract
  - FooPresenter
```

Then in your layout <activity_foo> add the lines for data binding.
```
<xml........>
<layout>
   <data> </data>

   /// Your layout code
</layout>
```
Remeber to put the `layout` only at the begining of the file excatly beneath the `<xml...>` definition or else the complier sometimes might not recognise the layout leading to not generating the classes.

Rebuild the project once to generate the binding class . **IMPORTANT**

Next define your classes as follows

1. FooContract

```
interface FooContract{
    public interface Presenter extends BaseMvpPresenter<View>{
        void checkView();
    }
    public interface  View extends BaseView{
        void checkData();
    }
}
```
2. FooActivity

```
public class FooActivity extends BaseActivity<FooActivity.Presenter, ActivityFooBining> implements HomeContract.View {
...
}

```
Remember that the `ActivityFooBining` wount generate until you rebuild after defining the layout.

3. FooPresenter
```
public class FooPresenter extends BasePresenter<FooContract.View> implements FooContract.Presenter {
...
}
```

Now we can access the view methods in FooPresenter and presenter methods from FooActivity.


***Side note:*** Always remember keep all your logic in the presenter and make your activity code look as dumb as possible. And everything related to view system must never be accessed in the presenter. That's it HAPPY CODING