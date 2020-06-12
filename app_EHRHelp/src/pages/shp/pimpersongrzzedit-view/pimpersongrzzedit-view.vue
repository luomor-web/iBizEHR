<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONGRZZEditViewBase from './pimpersongrzzedit-view-base.vue';

import view_form from '@widgets/pim-person/ryinfo-form-2-form/ryinfo-form-2-form.vue';

/**
 * 个人信息编辑视图
 *
 * @export
 * @class PIMPERSONGRZZEditView
 * @extends {PIMPERSONGRZZEditViewBase}
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
export default class PIMPERSONGRZZEditView extends PIMPERSONGRZZEditViewBase { }
</script>