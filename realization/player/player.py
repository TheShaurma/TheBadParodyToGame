class Player:
    def __init__(self, field, pos):
        """Put player on the assigned field at the assigned pos."""

        self._field = field
        self._pos = pos

        # self._pos[-1] is head; self._pos[0] is tail
        self._field[self._pos] = self

    def move_up(self):
        """Make player move up."""

        pos = (self._pos[0], self._pos[1]+1)

        self._movement_itself(pos)

    def move_right(self):
        """Make player move right."""

        pos = (self._pos[0]+1, self._pos[1])

        self._movement_itself(pos)

    def move_down(self):
        """Make player move down."""

        pos = (self._pos[0], self._pos[1]-1)

        self._movement_itself(pos)

    def move_left(self):
        """Make player move left."""

        pos = (self._pos[0]-1, self._pos[1])

        self._movement_itself(pos)

    def _movement_itself(self, pos):
        """Make player move to assigned pos."""

        try:
            if self._field[pos].is_barrier:
                self.rgb = (0xFF, 0x00, 0x00)
                return
        except AttributeError:
            pass
        self.rgb = (0x00, 0xFF, 0x00)

        old_pos = self._pos

        # put to new pos
        self._field[pos] = self
        self._pos = pos

        # delete from old pos
        del self._field[old_pos]

    rgb = (0x00, 0xFF, 0x00)
