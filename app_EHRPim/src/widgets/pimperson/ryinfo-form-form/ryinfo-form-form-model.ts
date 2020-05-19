/**
 * RYInfoForm 部件模型
 *
 * @export
 * @class RYInfoFormModel
 */
export default class RYInfoFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof RYInfoFormModel
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
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
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
        name: 'srfip_ygbh',
      },
      {
        name: 'srfip_zjlx',
      },
      {
        name: 'srfip_pimpersonname',
      },
      {
        name: 'srfip_zjhm',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'TEXT',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid2',
        prop: 'pimpersonid2',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'zjlx',
        prop: 'zjlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'SSCODELIST',
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
        name: 'nj',
        prop: 'nj',
        dataType: 'INT',
      },
      {
        name: 'xx',
        prop: 'xx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zp',
        prop: 'zp',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'dzyx',
        prop: 'dzyx',
        dataType: 'TEXT',
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
        name: 'hklx',
        prop: 'hklx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jg',
        prop: 'jg',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hjszd',
        prop: 'hjszd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hjdz',
        prop: 'hjdz',
        dataType: 'TEXT',
      },
      {
        name: 'csd',
        prop: 'csd',
        dataType: 'TEXT',
      },
      {
        name: 'postaladdress',
        prop: 'postaladdress',
        dataType: 'TEXT',
      },
      {
        name: 'sfdszn',
        prop: 'sfdszn',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ahtc',
        prop: 'ahtc',
        dataType: 'TEXT',
      },
      {
        name: 'rcxllx',
        prop: 'rcxllx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimmajorsetypename',
        prop: 'pimmajorsetypename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pcmrcxlname',
        prop: 'pcmrcxlname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jkzk',
        prop: 'jkzk',
        dataType: 'TEXT',
      },
      {
        name: 'jlczz',
        prop: 'jlczz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zzmm',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rtsj',
        prop: 'rtsj',
        dataType: 'DATE',
      },
      {
        name: 'rdsj',
        prop: 'rdsj',
        dataType: 'DATE',
      },
      {
        name: 'yglx',
        prop: 'yglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ygzt',
        prop: 'ygzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'workstate',
        prop: 'workstate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'rank',
        prop: 'rank',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gw',
        prop: 'gw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zj',
        prop: 'zj',
        dataType: 'SSCODELIST',
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
        name: 'gzzt',
        prop: 'gzzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gzzz',
        prop: 'gzzz',
        dataType: 'TEXT',
      },
      {
        name: 'gzbm',
        prop: 'gzbm',
        dataType: 'TEXT',
      },
      {
        name: 'gzkssj',
        prop: 'gzkssj',
        dataType: 'DATE',
      },
      {
        name: 'gzjssj',
        prop: 'gzjssj',
        dataType: 'DATE',
      },
      {
        name: 'sgyy',
        prop: 'sgyy',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimpersonname2',
        prop: 'pimpersonname2',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimpersonname3',
        prop: 'pimpersonname3',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sftberp',
        prop: 'sftberp',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hmd',
        prop: 'hmd',
        dataType: 'YESNO',
      },
      {
        name: 'blacklistreasons',
        prop: 'blacklistreasons',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid3',
        prop: 'pimpersonid3',
        dataType: 'PICKUP',
      },
      {
        name: 'pcmrcxlid',
        prop: 'pcmrcxlid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimmajorsetypeid',
        prop: 'pimmajorsetypeid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimperson',
        prop: 'pimpersonid',
        dataType: 'FONTKEY',
      },
    ]
  }

}