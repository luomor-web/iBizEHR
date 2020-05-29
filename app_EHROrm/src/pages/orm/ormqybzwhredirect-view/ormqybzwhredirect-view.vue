<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMQYBZWHRedirectViewBase from './ormqybzwhredirect-view-base.vue';


/**
 * 区域标准维护数据重定向视图
 *
 * @export
 * @class ORMQYBZWHRedirectView
 * @extends {ORMQYBZWHRedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ORMQYBZWHRedirectView extends ORMQYBZWHRedirectViewBase { }
</script>