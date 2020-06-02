/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pcmdetailid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmdetailname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'TEXT',
      },
      {
        name: 'zjhm',
        prop: 'zjhm',
        dataType: 'TEXT',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'jg',
        prop: 'jg',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nj',
        prop: 'nj',
        dataType: 'INT',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'TEXT',
      },
      {
        name: 'hyzk',
        prop: 'hyzk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'mz',
        prop: 'mz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hkxz',
        prop: 'hkxz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'TEXT',
      },
      {
        name: 'hjdz',
        prop: 'hjdz',
        dataType: 'TEXT',
      },
      {
        name: 'pimmajorsetypename',
        prop: 'pimmajorsetypename',
        dataType: 'TEXT',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yglx',
        prop: 'yglx',
        dataType: 'TEXT',
      },
      {
        name: 'dyxlbyyx',
        prop: 'dyxlbyyx',
        dataType: 'TEXT',
      },
      {
        name: 'dyxljssj',
        prop: 'dyxljssj',
        dataType: 'DATE',
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
        name: 'firsteducation',
        prop: 'firsteducation',
        dataType: 'YESNO',
      },
      {
        name: 'sfzgxl',
        prop: 'sfzgxl',
        dataType: 'YESNO',
      },
      {
        name: 'zgxlsxzy',
        prop: 'zgxlsxzy',
        dataType: 'TEXT',
      },
      {
        name: 'zgxlbyyx',
        prop: 'zgxlbyyx',
        dataType: 'TEXT',
      },
      {
        name: 'xllx',
        prop: 'xllx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xxlb',
        prop: 'xxlb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sbcjd',
        prop: 'sbcjd',
        dataType: 'TEXT',
      },
      {
        name: 'zzmm',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'px',
        prop: 'px',
        dataType: 'TEXT',
      },
      {
        name: 'bdwgznx',
        prop: 'bdwgznx',
        dataType: 'DECIMAL',
      },
      {
        name: 'bjgznx',
        prop: 'bjgznx',
        dataType: 'DECIMAL',
      },
      {
        name: 'careername',
        prop: 'careername',
        dataType: 'TEXT',
      },
      {
        name: 'zjxtgznx',
        prop: 'zjxtgznx',
        dataType: 'DECIMAL',
      },
      {
        name: 'cjgzsj',
        prop: 'cjgzsj',
        dataType: 'DATE',
      },
      {
        name: 'tozjdate',
        prop: 'tozjdate',
        dataType: 'DATE',
      },
      {
        name: 'dbdwsj',
        prop: 'dbdwsj',
        dataType: 'DATE',
      },
      {
        name: 'rank',
        prop: 'rank',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rdsj',
        prop: 'rdsj',
        dataType: 'DATE',
      },
      {
        name: 'dzjbjsj',
        prop: 'dzjbjsj',
        dataType: 'DATE',
      },
      {
        name: 'gw',
        prop: 'gw',
        dataType: 'TEXT',
      },
      {
        name: 'gznx',
        prop: 'gznx',
        dataType: 'DECIMAL',
      },
      {
        name: 'gwtype',
        prop: 'gwtype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jxkhcj',
        prop: 'jxkhcj',
        dataType: 'TEXT',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zcbh',
        prop: 'zcbh',
        dataType: 'TEXT',
      },
      {
        name: 'sfzckjs',
        prop: 'sfzckjs',
        dataType: 'YESNO',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimvocationalcatalogname',
        prop: 'pimvocationalcatalogname',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'TEXT',
      },
      {
        name: 'zgzsbh',
        prop: 'zgzsbh',
        dataType: 'TEXT',
      },
      {
        name: 'pimqualtypename',
        prop: 'pimqualtypename',
        dataType: 'TEXT',
      },
      {
        name: 'kstgkms',
        prop: 'kstgkms',
        dataType: 'TEXT',
      },
      {
        name: 'qsrq',
        prop: 'qsrq',
        dataType: 'DATE',
      },
      {
        name: 'jsrq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'htqx',
        prop: 'htqx',
        dataType: 'DATE',
      },
      {
        name: 'contracttype',
        prop: 'contracttype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'htsyq',
        prop: 'htsyq',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'pcmdetailid',
        prop: 'pcmdetailid',
        dataType: 'GUID',
      },
      {
        name: 'pcmdetail',
        prop: 'pcmdetailid',
        dataType: 'FONTKEY',
      },
    ]
  }

}