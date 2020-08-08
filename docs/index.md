## Welcome to the TL-UL Implementation Specification

This page is dedicated for the implementation specification of the TileLink Uncached Lightweight (TL-UL) protocol.

The TL-UL protocol conforms to the [Tilelink 1.7.1 specification](https://sifive.cdn.prismic.io/sifive%2F57f93ecf-2c42-46f7-9818-bcdd7d39400a_tilelink-spec-1.7.1.pdf) provided by SiFive.

### a_size functionality
#### Get
`a_size` indicates the total amount of data the requesting agent wishes to read in terms of _log2(bytes)_. `a_size` represents the size of the resulting `AccessAckData` response.

#### Possbilities of a_size in Get
 a_size  | Interpretation </br>(2<sup>a_size</sup>) bytes 
 ------  | --------------------------------------------------------
  0      | Slave returns (2<sup>0</sup> = 1 byte) in AccessAckData   
  1      | Slave returns (2<sup>1</sup> = 2 bytes) in AccessAckData  
  2      | Slave returns (2<sup>2</sup> = 4 bytes) in AccessAckData
  
  | a_size | Interpretation (2<sup>a_size</sup>) bytes | Third priority |
|-------|--------|---------|
| ambrosia | gala | red delicious |
| pink lady | jazz | macintosh |
| honeycrisp | granny smith | fuji |

<table>
<colgroup>
<col width="50%" />
<col width="50%" />
</colgroup>
<thead>
<tr class="header">
<th>a_size</th>
 <th markdown="span">Interpretation </br>2<sup>a_size</sup> bytes </th>
</tr>
</thead>
<tbody>
<tr>
<td markdown="span">First column **fields**</td>
<td markdown="span">Some descriptive text. This is a markdown link to [Google](http://google.com). Or see [some link][mydoc_tags].</td>
</tr>
<tr>
<td markdown="span">Second column **fields**</td>
<td markdown="span">Some more descriptive text.
</td>
</tr>
</tbody>
</table>

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/hadirkhan10/TileLink/settings). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://github.com/contact) and we’ll help you sort it out.
