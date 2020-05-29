<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMWORKHISTORYRedirectViewBase from './pimworkhistoryredirect-view-base.vue';


/**
 * 工作履历数据重定向视图
 *
 * @export
 * @class PIMWORKHISTORYRedirectView
 * @extends {PIMWORKHISTORYRedirectViewBase}
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
export default class PIMWORKHISTORYRedirectView extends PIMWORKHISTORYRedirectViewBase { }
</script>