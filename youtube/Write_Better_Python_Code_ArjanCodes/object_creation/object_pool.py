'''
    Object Pool gives a better way to manage you instances.

    They are useful when the creation of a instance is expansive
'''


class ReusableDummy:
    def __repr__(self) -> str:
        return f'Dummy at {id(self)}'


class Pool:
    def __init__(self, pool_type, max_instances=2) -> None:
        self.max_instances = max_instances
        self._free = []
        self._used = []
        self._type = pool_type

    def _create_instance(self) -> None:
        if len(self._used) >= self.max_instances:
            raise Exception("Max instances value reached")

        self._free.append(self._type())

    def release(self, instance) -> None:
        self._used.remove(instance)
        self._free.append(instance)
        print('Instance released', id(instance))

    def acquire(self):
        if not self._free:
            self._create_instance()

        instance = self._free.pop()
        self._used.append(instance)
        print('Instance acquired', id(instance))

        return instance

class PoolManager:
    def __init__(self, pool: Pool) -> None:
        self.pool = pool

    def __enter__(self):
        self.obj = self.pool.acquire()
        return self.obj

    def __exit__(self, type, value, traceback):
        self.pool.release(self.obj)


def pool_state_helper(pool):
    print('\nPool State:')
    print('Free:', pool._free)
    print('Used:', pool._used, '\n')


if __name__ == '__main__':
    print('Creating: Pool(ReusableDummy, 2)')
    pool = Pool(ReusableDummy, 2)

    pool_state_helper(pool)

    print('Before PoolManager')
    with PoolManager(pool) as pm:
        print('Inside PoolManager')
    print('After PoolManager')

    pool_state_helper(pool)

    print('Acquiring two objects')
    a = pool.acquire()
    b = pool.acquire()

    pool_state_helper(pool)

    print('Releasing object', a)
    pool.release(a)

    pool_state_helper(pool)

    print('Reacquiring object')
    a = pool.acquire()

    pool_state_helper(pool)

    print('Acquire more than max_instances will raise error')
    while True:
        pool.acquire()
