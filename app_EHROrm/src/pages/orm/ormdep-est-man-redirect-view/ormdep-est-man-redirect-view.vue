<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDepEstManRedirectViewBase from './ormdep-est-man-redirect-view-base.vue';


/**
 * 部门编制管理数据重定向视图
 *
 * @export
 * @class ORMDepEstManRedirectView
 * @extends {ORMDepEstManRedirectViewBase}
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
export default class ORMDepEstManRedirectView extends ORMDepEstManRedirectViewBase { }
</script>