<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBQRedirectViewBase from './ormxmbqredirect-view-base.vue';


/**
 * 项目标签数据重定向视图
 *
 * @export
 * @class ORMXMBQRedirectView
 * @extends {ORMXMBQRedirectViewBase}
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
export default class ORMXMBQRedirectView extends ORMXMBQRedirectViewBase { }
</script>