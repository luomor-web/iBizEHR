<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMENCLOSUREFilePreViewCustomViewBase from './pimenclosurefile-pre-view-custom-view-base.vue';


/**
 * 表格附件预览
 *
 * @export
 * @class PIMENCLOSUREFilePreViewCustomView
 * @extends {PIMENCLOSUREFilePreViewCustomViewBase}
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
export default class PIMENCLOSUREFilePreViewCustomView extends PIMENCLOSUREFilePreViewCustomViewBase { }
</script>