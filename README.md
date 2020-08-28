## Hermes: A ShExCSV to ShExC Translator
Hermes is developed and maintained by WESO Research Group. Hermes is a Java based library that allows to translate from [Shape Expressions](https://shex.io/) tabular formats like ShExCSV to the [Shape Expressions Compact Syntax](https://shex.io/shex-semantics/index.html#shexc).

This library can be enveloped in to a rest api server and used form other languages but at the moment that feature is not provided within this repository. In order to see the roadmap of the project you can refeer to [Long Term Roadmap (LTR)](https://github.com/weso/hermes/issues/4) issue.

### How to use
Once you have your environment ready you can start using Hermes from your CLI as follows:

```shell
hermes --prefixesFile=prefixes.csv --shapesFile=shapes.csv --outDir=./out
```

#### Prefixes File
The prefixes file is a CSV file that contains all the prefix declarations that will be used by the Shape Expressions that are in the `shapes.csv` file. The format of this file is as follows:

|Prefix|URI|
|:----:|:--|
||<http://example.org/>|
|xsd|<http://www.w3.org/2001/XMLSchema#>|
|foaf|<http://xmlns.com/foaf/0.1/>|
|...|...|

#### Shapes File
The shapes file is a CSV file tht contains all the shapes declarations. It uses the prefixes defined at `prefixes.csv` file. The format of this file is as follows:

|Shape Label|Constraint Property|Constraint|Min|Max|
|:---------:|:-----------------:|:--------:|:-:|:-:|
|:User|schema:name|xsd:string|1|1|
|:User|schema:bithday|xsd:date|0|1|
|:User|schema:gender| [ schema:Male schema:Female ] OR xsd:string|1|1|
|:User|schema:owns|IRI @:Car|0|-|
|:Car|schema:plateNumber|xsd:string|1|1|
|...|...|...|...|...|

#### Generated File
For the previous input files Hermes will generate in te uotput directory a Shape Expression Compact Syntax file as follows:

```turtle
PREFIX :       <http://example.org/>
PREFIX schema: <http://schema.org/>
PREFIX xsd:    <http://www.w3.org/2001/XMLSchema#>

:User {
  schema:name          xsd:string  ;
  schema:birthDate     xsd:date?   ;
  schema:gender        [ schema:Male schema:Female ] OR xsd:string ;
  schema:knows         IRI @:User*
}

:Car {
  schema:plateNumber   xsd:string  ;
}
```

## License
Hermes is primarily distributed under the terms of the MIT license.

See [LICENSE](LICENSE) for details.
