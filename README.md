# KnightVision
Performance focused, robust, and lightweight lighting control that is powerful but allows for the user to tinker easily


### KERNEL:
objects:
- Channel
    - Dimmer
	- GDTF
- DMX Universe
- Patch - parent of channel objects
- Interface
	- ArtNet
- Cuestack
	- Cue - (snapshot of fixture paramters)
- Groups - (basically a symbolic link for fixtures)
- Palettes - (specific paramter that applies like a symlink)

CLI Debug interface:
- unix-like command line with use similarity to EOS
- god statement: `type name [param] value`

### GUI:
(java? or stick with c?)

- CLI
- GUI objects
- etc...
	
EX: `channel 20 @ 2;`\
or: `group 2 color palette 5;`\
or: `record cue 2;`\
or: `channel 2>10 @ full; select-last color gradient RED>BLUE`
