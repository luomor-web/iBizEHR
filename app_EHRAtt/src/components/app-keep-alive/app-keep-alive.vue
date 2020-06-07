<script>
export default {
    name: 'app-keep-alive',
    render: function render() {
        let _this = this;
        let slot = _this.$slots.default;
        let vnode = _this.getFirstComponentChild(slot);
        let componentOptions = vnode && vnode.componentOptions;
        if (componentOptions) {
            // check pattern
            let name = _this.getComponentName(componentOptions);
            let ref = _this;
            let include = ref.include;
            let exclude = ref.exclude;
            let routerList = ref.routerList;
            let route = ref.$route;
            if (
                // not included
                (include && (!name || !_this.matches(include, name))) ||
                // excluded
                (exclude && name && _this.matches(exclude, name)) ||
                (routerList && (!route.fullPath && !_this.matches(routerList, route.fullPath)))
            ) {
                return vnode
            }

            let ref$1 = _this;
            let cache = ref$1.cache;
            let keys = ref$1.keys;
            let key = vnode.key == null
                // same constructor may get registered as different local components
                // so cid alone is not enough (#3269)
                ? componentOptions.Ctor.cid + (componentOptions.tag ? ("::" + (componentOptions.tag)) : '')
                : vnode.key;
            if (cache[key]) {
                vnode.componentInstance = cache[key].componentInstance;
                // make current key freshest
                _this.remove(keys, key);
                keys.push(key);
            } else {
                cache[key] = vnode;
                keys.push(key);
                // prune oldest entry
                if (_this.max && keys.length > parseInt(_this.max)) {
                    _this.pruneCacheEntry(cache, keys[0], keys, _this._vnode);
                }
            }

            vnode.data.keepAlive = true;
            vnode.data.curPath = route.fullPath;
        }
        return vnode || (slot && slot[0])
    },
    props: {
        include: [String, RegExp, Array],
        exclude: [String, RegExp, Array],
        max: [String, Number],
        routerList: [Array]
    },
    data: function(){
        return {
            _toString: Object.prototype.toString
        }
    },
    created: function () {
        this.cache = Object.create(null);
        this.keys = [];
    },
    destroyed: function () {
        let _this = this;
        for (let key in _this.cache) {
            _this.pruneCacheEntry(_this.cache, key, _this.keys);
        }
    },
    watch: {
        'include': function (val) {
            let _this = this;
            _this.pruneCache(function (name) {
                return _this.matches(val, name);
            });
        },
        'exclude': function (val) {
            let _this = this;
            _this.pruneCache(function (name) {
                return !_this.matches(val, name);
            });
        },
        'routerList': function(val) {
            let _this = this;
            _this.pruneCache2(function (name) {
                return !_this.matches(val, name);
            });
        }
    },
    methods: {
        pruneCacheEntry(cache, key, keys, current) {
            let cached = cache[key];
            if (cached) {
                cached.componentInstance.$destroy();
            }
            cache[key] = null;
            this.remove(keys, key);
        },
        pruneCache(filter) {
            let _this = this;
            let cache = _this.cache;
            let keys = _this.keys;
            let _vnode = _this._vnode;
            for (let key in cache) {
                let cachedNode = cache[key];
                if (cachedNode) {
                    let name = _this.getComponentName(cachedNode.componentOptions);
                    if (name && !filter(name)) {
                        _this.pruneCacheEntry(cache, key, keys, _vnode);
                    }
                }
            }
        },
        pruneCache2(filter) {
            let _this = this;
            let cache = _this.cache;
            let keys = _this.keys;
            let _vnode = _this._vnode;
            for (let key in cache) {
                let cachedNode = cache[key];
                if (cachedNode) {
                    let name = cachedNode.data.curPath;
                    if (name && filter(name)) {
                        _this.pruneCacheEntry(cache, key, keys, _vnode);
                    }
                }
            }
        },
        matches(pattern, name) {
            if (Array.isArray(pattern)) {
                return pattern.indexOf(name) > -1
            } else if (typeof pattern === 'string') {
                return pattern.split(',').indexOf(name) > -1
            } else if (this.isRegExp(pattern)) {
                return pattern.test(name)
            }
            /* istanbul ignore next */
            return false
        },
        getComponentName(opts) {
            return opts && (opts.Ctor.options.name || opts.tag)
        },
        getFirstComponentChild(children) {
            let _this = this;
            if (Array.isArray(children)) {
                for (let i = 0; i < children.length; i++) {
                    let c = children[i];
                    if (_this.isDef(c) && (_this.isDef(c.componentOptions) || _this.isAsyncPlaceholder(c))) {
                        return c
                    }
                }
            }
        },
        isAsyncPlaceholder(node) {
            return node.isComment && node.asyncFactory
        },
        isDef(v) {
            return v !== undefined && v !== null
        },
        isRegExp(v) {
            return this._toString.call(v) === '[object RegExp]'
        },
        remove(arr, item) {
            if (arr.length) {
                let index = arr.indexOf(item);
                if (index > -1) {
                    return arr.splice(index, 1)
                }
            }
        }
    }
}
</script>

<style lang="less">

</style>

