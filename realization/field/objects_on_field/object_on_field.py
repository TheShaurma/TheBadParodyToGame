class ObjectOnField:
    def __init__(self, field, pos):
        self._field = field
        self._pos = pos
        self._field[self._pos] = self

    rgb = (0xFF, 0xFF, 0xFF)
    is_barrier = True
