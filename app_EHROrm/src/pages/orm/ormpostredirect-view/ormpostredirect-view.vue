<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTRedirectViewBase from './ormpostredirect-view-base.vue';


/**
 * 岗位管理数据重定向视图
 *
 * @export
 * @class ORMPOSTRedirectView
 * @extends {ORMPOSTRedirectViewBase}
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
export default class ORMPOSTRedirectView extends ORMPOSTRedirectViewBase { }
</script>