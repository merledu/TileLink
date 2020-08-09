---
title: Get
filename: get.md
--- 

# TileLink Get Operation Overview
This is the elaboration of the `Get` operation in TL-UL. The `Get` operation is initiated by the Host or TileLink Master and is responded by the slave with an `AccessAckData`.

## Get: (a_size = 0)
This configuration means that the master wants to read a single byte of data. It expects the response `AccessAckData` to have `d_size = 0` which means `d_data` carries an 8-bit data payload.

For this overview we will assume the following memory organization

<img src="https://github.com/hadirkhan10/TileLink/blob/master/docs/assets/tilelink.png">
