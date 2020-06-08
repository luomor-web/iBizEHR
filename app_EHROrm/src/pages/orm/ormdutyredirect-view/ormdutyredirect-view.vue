<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYRedirectViewBase from './ormdutyredirect-view-base.vue';


/**
 * 职务管理数据重定向视图
 *
 * @export
 * @class ORMDUTYRedirectView
 * @extends {ORMDUTYRedirectViewBase}
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
export default class ORMDUTYRedirectView extends ORMDUTYRedirectViewBase { }
</script>