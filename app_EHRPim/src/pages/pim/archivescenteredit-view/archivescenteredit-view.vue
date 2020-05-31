<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVESCENTEREditViewBase from './archivescenteredit-view-base.vue';

import view_form from '@widgets/pim-archives-center/main-form/main-form.vue';

/**
 * 档案室管理编辑视图
 *
 * @export
 * @class ARCHIVESCENTEREditView
 * @extends {ARCHIVESCENTEREditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ARCHIVESCENTEREditView extends ARCHIVESCENTEREditViewBase { }
</script>