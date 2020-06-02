<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALMAJORRedirectViewBase from './pimqualmajorredirect-view-base.vue';


/**
 * 执业资格专业数据重定向视图
 *
 * @export
 * @class PIMQUALMAJORRedirectView
 * @extends {PIMQUALMAJORRedirectViewBase}
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
export default class PIMQUALMAJORRedirectView extends PIMQUALMAJORRedirectViewBase { }
</script>