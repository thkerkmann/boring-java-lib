# my boring java library
trying to get my personal helpful classes into a public space

## to use in other projects

### add repository url
```
<repositories>
	<repository>
		<id>github</id>
		<name>GitHub thkerkmann Apache Maven Packages</name>
		<url>https://maven.pkg.github.com/thkerkmann</url>
		<releases><enabled>true</enabled></releases>
		<snapshots><enabled>true</enabled></snapshots>
	</repository>
</repositories>
```

### then use dependency
```
<dependency>
    <groupId>de.kerkmann</groupId>
    <artifactId>common</artifactId>
    <version>1.0.0</version>
</dependency>
```
### you will need an access token in maven settings.xml

```
<!--
The recommended way to authenticate when using the GitHub API or command line is to use a personal access token (PAT):
-->
<settings>
	<servers>
		<server>
			<id>github</id>
			<password>your_access_token_here</password>
		</server>
	</servers>
</settings>
```
