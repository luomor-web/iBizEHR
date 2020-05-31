/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'htqx',
          prop: 'htqx',
          dataType: 'DATE',
        },
        {
          name: 'gwtype_text',
          prop: 'gwtype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xllx_text',
          prop: 'xllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bdwgznx',
          prop: 'bdwgznx',
          dataType: 'DECIMAL',
        },
        {
          name: 'qsrq',
          prop: 'qsrq',
          dataType: 'DATE',
        },
        {
          name: 'zjxtgznx',
          prop: 'zjxtgznx',
          dataType: 'DECIMAL',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmdetailname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmdetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmdetailid',
          dataType: 'GUID',
        },
        {
          name: 'cjgzsj',
          prop: 'cjgzsj',
          dataType: 'DATE',
        },
        {
          name: 'gznx',
          prop: 'gznx',
          dataType: 'DECIMAL',
        },
        {
          name: 'htlb_text',
          prop: 'htlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'rank',
          prop: 'rank',
          dataType: 'SSCODELIST',
        },
        {
          name: 'dyxljssj',
          prop: 'dyxljssj',
          dataType: 'DATE',
        },
        {
          name: 'xxlb_text',
          prop: 'xxlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xb_text',
          prop: 'xb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'hkxz_text',
          prop: 'hkxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xb',
          prop: 'xb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xllx',
          prop: 'xllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'yglx',
          prop: 'yglx',
          dataType: 'TEXT',
        },
        {
          name: 'zzmm',
          prop: 'zzmm',
          dataType: 'SSCODELIST',
        },
        {
          name: 'mz_text',
          prop: 'mz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimvocationalcatalogname',
          prop: 'pimvocationalcatalogname',
          dataType: 'TEXT',
        },
        {
          name: 'tozjdate',
          prop: 'tozjdate',
          dataType: 'DATE',
        },
        {
          name: 'sfzckjs',
          prop: 'sfzckjs',
          dataType: 'YESNO',
        },
        {
          name: 'zcbh',
          prop: 'zcbh',
          dataType: 'TEXT',
        },
        {
          name: 'dyxl',
          prop: 'dyxl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'gw',
          prop: 'gw',
          dataType: 'TEXT',
        },
        {
          name: 'zgxxlb',
          prop: 'zgxxlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimmajorsetypename',
          prop: 'pimmajorsetypename',
          dataType: 'TEXT',
        },
        {
          name: 'dyxlbyyx',
          prop: 'dyxlbyyx',
          dataType: 'TEXT',
        },
        {
          name: 'zgxl',
          prop: 'zgxl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xxlb',
          prop: 'xxlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'contracttype',
          prop: 'contracttype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'TEXT',
        },
        {
          name: 'dyxl_text',
          prop: 'dyxl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zjhm',
          prop: 'zjhm',
          dataType: 'TEXT',
        },
        {
          name: 'zgxllx',
          prop: 'zgxllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'contracttype_text',
          prop: 'contracttype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'rzqd',
          prop: 'rzqd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sbcjd',
          prop: 'sbcjd',
          dataType: 'TEXT',
        },
        {
          name: 'htsyq',
          prop: 'htsyq',
          dataType: 'TEXT',
        },
        {
          name: 'hkxz',
          prop: 'hkxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'zgxllx_text',
          prop: 'zgxllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zgxlbyyx',
          prop: 'zgxlbyyx',
          dataType: 'TEXT',
        },
        {
          name: 'rank_text',
          prop: 'rank',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zgxlsxzy',
          prop: 'zgxlsxzy',
          dataType: 'TEXT',
        },
        {
          name: 'zw',
          prop: 'zw',
          dataType: 'SSCODELIST',
        },
        {
          name: 'htlb',
          prop: 'htlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zzmm_text',
          prop: 'zzmm',
          dataType: 'SSCODELIST',
        },
        {
          name: 'gwtype',
          prop: 'gwtype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bjgznx',
          prop: 'bjgznx',
          dataType: 'DECIMAL',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'rdsj',
          prop: 'rdsj',
          dataType: 'DATE',
        },
        {
          name: 'rzqd_text',
          prop: 'rzqd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'hyzk',
          prop: 'hyzk',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zgxljssj',
          prop: 'zgxljssj',
          dataType: 'DATE',
        },
        {
          name: 'dyxlsxzy',
          prop: 'dyxlsxzy',
          dataType: 'TEXT',
        },
        {
          name: 'jxkhcj',
          prop: 'jxkhcj',
          dataType: 'TEXT',
        },
        {
          name: 'jsrq',
          prop: 'jsrq',
          dataType: 'DATE',
        },
        {
          name: 'mz',
          prop: 'mz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'hyzk_text',
          prop: 'hyzk',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimqualtypename',
          prop: 'pimqualtypename',
          dataType: 'TEXT',
        },
        {
          name: 'hjdz',
          prop: 'hjdz',
          dataType: 'TEXT',
        },
        {
          name: 'zgzsbh',
          prop: 'zgzsbh',
          dataType: 'TEXT',
        },
        {
          name: 'jg',
          prop: 'jg',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zgxxlb_text',
          prop: 'zgxxlb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'csrq',
          prop: 'csrq',
          dataType: 'DATE',
        },
        {
          name: 'dzjbjsj',
          prop: 'dzjbjsj',
          dataType: 'DATE',
        },
        {
          name: 'dbdwsj',
          prop: 'dbdwsj',
          dataType: 'DATE',
        },
        {
          name: 'zgxl_text',
          prop: 'zgxl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'careername',
          prop: 'careername',
          dataType: 'TEXT',
        },
        {
          name: 'nj',
          prop: 'nj',
          dataType: 'INT',
        },
        {
          name: 'zw_text',
          prop: 'zw',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'pcmdetail',
          prop: 'pcmdetailid',
        },
        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}