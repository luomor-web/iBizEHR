<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEDUCATIONRedirectViewBase from './pimeducationredirect-view-base.vue';


/**
 * 教育信息数据重定向视图
 *
 * @export
 * @class PIMEDUCATIONRedirectView
 * @extends {PIMEDUCATIONRedirectViewBase}
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
export default class PIMEDUCATIONRedirectView extends PIMEDUCATIONRedirectViewBase { }
</script>