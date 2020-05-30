<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBMXRedirectViewBase from './ormxmbmxredirect-view-base.vue';


/**
 * 项目部明细数据重定向视图
 *
 * @export
 * @class ORMXMBMXRedirectView
 * @extends {ORMXMBMXRedirectViewBase}
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
export default class ORMXMBMXRedirectView extends ORMXMBMXRedirectViewBase { }
</script>