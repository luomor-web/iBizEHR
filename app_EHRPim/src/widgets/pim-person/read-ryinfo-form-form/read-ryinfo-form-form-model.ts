/**
 * ReadRYInfoForm 部件模型
 *
 * @export
 * @class ReadRYInfoFormModel
 */
export default class ReadRYInfoFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof ReadRYInfoFormModel
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
        name: 'srfip_pimpersonname',
      },
      {
        name: 'srfip_zjlx',
      },
      {
        name: 'srfip_ygbh',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
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
        name: 'jg',
        prop: 'jg',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
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
        name: 'mz',
        prop: 'mz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hyzk',
        prop: 'hyzk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zp',
        prop: 'zp',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'zzmm',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'rank',
        prop: 'rank',
        dataType: 'SSCODELIST',
      },
      {
        name: 'cjgzsj',
        prop: 'cjgzsj',
        dataType: 'DATE',
      },
      {
        name: 'dbdwsj',
        prop: 'dbdwsj',
        dataType: 'DATE',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'TEXT',
      },
      {
        name: 'dzyx',
        prop: 'dzyx',
        dataType: 'TEXT',
      },
      {
        name: 'hightitle',
        prop: 'hightitle',
        dataType: 'TEXT',
      },
      {
        name: 'higheducation',
        prop: 'higheducation',
        dataType: 'SSCODELIST',
      },
      {
        name: 'firsteducation',
        prop: 'firsteducation',
        dataType: 'SSCODELIST',
      },
      {
        name: 'certtificate',
        prop: 'certtificate',
        dataType: 'TEXT',
      },
      {
        name: 'pcmrcxlid',
        prop: 'pcmrcxlid',
        dataType: 'PICKUP',
      },
      {
        name: 'hklx',
        prop: 'hklx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yglx',
        prop: 'yglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hjszd',
        prop: 'hjszd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'csd',
        prop: 'csd',
        dataType: 'TEXT',
      },
      {
        name: 'jkzk',
        prop: 'jkzk',
        dataType: 'TEXT',
      },
      {
        name: 'ahtc',
        prop: 'ahtc',
        dataType: 'TEXT',
      },
      {
        name: 'xx',
        prop: 'xx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sfdszn',
        prop: 'sfdszn',
        dataType: 'SSCODELIST',
      },
      {
        name: 'postaladdress',
        prop: 'postaladdress',
        dataType: 'TEXT',
      },
      {
        name: 'rdsj1',
        prop: 'rdsj',
        dataType: 'DATE',
      },
      {
        name: 'rtsj',
        prop: 'rtsj',
        dataType: 'DATE',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ygzt',
        prop: 'ygzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hmd',
        prop: 'hmd',
        dataType: 'YESNO',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'pimperson',
        prop: 'pimpersonid',
        dataType: 'FONTKEY',
      },
    ]
  }

}