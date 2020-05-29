<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGRedirectViewBase from './ormorgredirect-view-base.vue';


/**
 * 组织管理数据重定向视图
 *
 * @export
 * @class ORMORGRedirectView
 * @extends {ORMORGRedirectViewBase}
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
export default class ORMORGRedirectView extends ORMORGRedirectViewBase { }
</script>