__all__ = ['Field', 'PositionError']


class Field:
    def __init__(self, resolution=(15, 15)):
        """Create a field with assigned resolution.

        Resolution of field will be infinit, if assigned 'inf'.

        """

        if resolution != 'inf':
            self._x_min = 0
            self._x_max = resolution[0]
            self._y_min = 0
            self._y_max = resolution[1]
        else:
            self._x_min = -float('inf')
            self._x_max = float('inf')
            self._y_min = -float('inf')
            self._y_max = float('inf')

        self.__field_itself = {}

    def __prepare_pos(self, pos):
        """Creates and returns tuple object from slice or tuple object."""

        try:
            pos = (pos.start, pos.stop)
        except AttributeError:
            pass

        return pos

    def __check_pos(self, pos):
        x, y = pos

        if (x < self._x_min or
            x > self._x_max or
            y < self._y_min or
                y > self._y_max):
            raise PositionError(pos)

    def __getitem__(self, pos):
        """If on assigned pos field hes an object than return it, else return None."""

        pos = self.__prepare_pos(pos)
        self.__check_pos(pos)

        return self.__field_itself.get(pos)

    def __setitem__(self, pos, obj):
        """Set the assigned object to the assigned pos."""

        pos = self.__prepare_pos(pos)
        self.__check_pos(pos)

        self.__field_itself[pos] = obj

    def __delitem__(self, pos):
        """Delete the object from the assigned pos."""

        pos = self.__prepare_pos(pos)
        self.__check_pos(pos)

        del self.__field_itself[pos]

    def __iter__(self): return iter(self.__field_itself)


class PositionError(Exception):
    """Position out of range exception."""

    def __init__(self, pos):
        self.pos = pos

    def __str__(self):
        return 'Position {} out of range.'.format(self.pos)


if __name__ == '__main__':
    def print_field(field: Field):
        [print(str(x)[-1], end=' ') for x in range(15+1)]
        print()

        for y in range(15, 0-1, -1):
            for x in range(15+1):
                if field[x:y] is not None:
                    print(field[x:y], end=' ')
                else:
                    print('.', end=' ')
            print(y)

    f = Field()

    while True:
        f[int(input('x: ')):int(input('y: '))] = '#'

        print_field(f)
